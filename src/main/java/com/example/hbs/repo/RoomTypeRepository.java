package com.example.hbs.repo;

import com.example.hbs.domain.RoomType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoomTypeRepository extends CrudRepository<RoomType, Integer> {
    Optional<RoomType> findByType(String type);

    List<RoomType> findByHotelId(Integer hotelId);


}
