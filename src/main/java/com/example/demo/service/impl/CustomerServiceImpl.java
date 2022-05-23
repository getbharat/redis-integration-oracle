package com.example.demo.service.impl;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public Customer save(final Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public Customer getCustomerById(final Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }
}
