package com.example.hbs.repo;

import com.example.hbs.domain.Booking;
import com.example.hbs.domain.Hotel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookingRepository extends CrudRepository<Booking,Integer> {
    Optional<Booking> findById(String name);
}
