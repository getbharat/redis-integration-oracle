# redis-integration-oracle, the project integrates redis with oracle.

### Prerequisites 
- Install Orcale 19c. If you don't want to install oracle 19c, pull the image from docker hub and run it as a container.
- Java 11
- Maven 3.8.4
- Redis. Redis image can be pulled from docker hub.

### To run the application, follow the below steps.
 - Connect oracle DB using sys.
 - Create user using the create-alert-user script.
 - Connect to the newly created user, and create tables using create-alert-table script.
 - Pull redis image from docker hub, and run it as a container using command ``docker run -p 6379:6379 -d redis redis-server --requirepass "password"``
 - Start the spring boot application.
 - Create some customers using POST call - http://localhost:8090/customer/v1/add, request body example-
      
        {
          "customerName":"VMWare"
        }

 - Add some alerts using POST call - http://localhost:8090/alert/v1/add, request body example-
  
       {
          "name":"Software news",
          "description":"Software News",
          "query":"(acquisition && software) || (stock market && software) || (software && piracy) || (Software && bankruptcy) || (Tech Giants) || (Zero day vulnerability) || (software && (attack hackers))",
          "customer":
          {
           "customerId":100
          }
       }
       
  - Get all the alerts that belong to a customer using GET call - http://localhost:8090/alert/v1/getAllCustomerAlerts/{customerId}, response body example-
        
        {
           "list": 
           [
              {
                  "alertId": 120,
                  "name": "Crime News Alert",
                  "description": "Crime News",
                  "query": "serial killer or crime or robbery or rape or murder or explosion or gang war or drugs or attack or exlosive or suicide"
              },
              {
                  "alertId": 109,
                  "name": "News Alert",
                  "description": "Daily Businees News",
                  "query": "finance or business or money or financial institutes or stock marked or mutual funds"
              },
              {
                  "alertId": 141,
                  "name": "Software news",
                  "description": "Software News",
                  "query": "(acquisition && software) || (stock market && software) || (software && piracy) || (Software && bankruptcy) || (Tech Giants) || (Zero day vulnerability) || (software && (attack hackers))"
              },
              {
                  "alertId": 123,
                  "name": "Alert Article 370",
                  "description": "Article 370 in Indian",
                  "query": "Jammu and Kashmir issue or article 370"
              }
            ],
            "customerId": 100
        }
        
        
   - Observe that when alerts are queried for the first time for a customer, a sql query is fired, but when you again query the alerts for the same customer, cached record for that customer is returned. When you add a new alert for the same customer, the cached record is evicted. A record is cached for 10 mins, it can be changed [here](https://github.com/getbharat/redis-integration-oracle/blob/master/src/main/resources/application.properties#L19).   


       
  
