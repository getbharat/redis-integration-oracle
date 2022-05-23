package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/customer/v1")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody final Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/get/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") final Long customerId) {
        return customerService.getCustomerById(customerId);
    }
}
