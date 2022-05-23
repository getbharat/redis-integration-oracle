package com.example.demo.service;

import com.example.demo.model.Customer;

public interface CustomerService {

    Customer save(final Customer customer);

    Customer getCustomerById( final Long customerId);
}
