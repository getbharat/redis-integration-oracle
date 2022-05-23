package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {


    @Id
    @Column(name="customer_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long customerId;

    @Column(name="name")
    private String customerName;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference // It is the forward part of reference – the one that gets serialized normally.
    private Set<Alert> alerts;

    public Customer() {
    }
    public Customer(Long customerId, String customerName, Set<Alert> alerts) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.alerts = alerts;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Set<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(Set<Alert> alerts) {
        this.alerts = alerts;
    }
}
