package com.example.demo.controller;

import com.example.demo.model.Alert;
import com.example.demo.model.AlertResponse;
import com.example.demo.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/alert/v1")
@RestController
public class AlertController {

    @Autowired
    private AlertService alertService;

    @GetMapping("/getAllCustomerAlerts/{customerId}")
    public AlertResponse getAlertsByCustomerId(@PathVariable("customerId") final Long customerId){
        return alertService.getAlertsByCustomerId(customerId);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> saveAlert(@RequestBody final Alert alert){
        return  ResponseEntity.ok(alertService.saveAlert(alert, alert.getCustomer().getCustomerId()));
    }

    @GetMapping("/getAlert/{alertId}")
    public ResponseEntity<Alert> getAlertById(@PathVariable("alertId") Long alertId){
       return ResponseEntity.ok(alertService.getAlertById(alertId));
    }
}
