package com.example.hbs.repo;

import com.example.hbs.domain.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, Integer> {

    List<Room> findByRoomTypeIdAndVacantTrue(Integer roomTypeId);

    @Override
    Optional<Room> findById(Integer integer);

    Optional<Room> findByRoomTypeIdAndRoomNumber(Integer roomTypeId, Integer roomNumber);
}
