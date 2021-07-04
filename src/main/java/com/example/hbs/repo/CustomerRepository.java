package com.example.hbs.repo;

import com.example.hbs.domain.Account;
import com.example.hbs.domain.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Optional<Customer> findById(String name);
    Optional<Customer> findByUsername(String userName);


}
