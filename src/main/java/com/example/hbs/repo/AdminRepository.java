package com.example.hbs.repo;

import com.example.hbs.domain.Admin;
import com.example.hbs.domain.Hotel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdminRepository  extends CrudRepository<Admin, Integer> {
    Optional<Admin> findByUsername(String userName);



}
