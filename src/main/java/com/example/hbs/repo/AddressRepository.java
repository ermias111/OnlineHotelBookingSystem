package com.example.hbs.repo;

import com.example.hbs.domain.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address, Integer> {
    Optional<Address> findByPhone(String phone);
}
