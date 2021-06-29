package com.example.hbs.repo;

import com.example.hbs.domain.Account;
import com.example.hbs.domain.Hotel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {
    List<Hotel> findByAddressCity(String name);
    List<Hotel> findByAddress_District(String district);
    Optional<Hotel> findByUsername(String userName);

}
