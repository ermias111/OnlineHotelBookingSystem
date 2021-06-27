package com.example.hbs.repo;

import com.example.hbs.domain.Hotel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {

    Optional<Hotel> findById(String name);
}
