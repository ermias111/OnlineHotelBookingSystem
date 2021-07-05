package com.example.hbs.service;

import com.example.hbs.domain.Address;
import com.example.hbs.domain.Booking;
import com.example.hbs.domain.Customer;

import com.example.hbs.domain.Role;
import com.example.hbs.repo.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(String username, String password, Role role, String firstname, String lastname, String email){

        return customerRepository.save(new Customer(username, password, role, firstname,lastname,email));
    }


}
