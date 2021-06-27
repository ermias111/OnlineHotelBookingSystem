package com.example.hbs.service;

import com.example.hbs.domain.Address;
import com.example.hbs.domain.Customer;

import com.example.hbs.repo.CustomerRepository;

public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(String firstname, String lastname, String email, Address address){
        return customerRepository.save(new Customer(firstname,lastname,email, address));
    }
}
