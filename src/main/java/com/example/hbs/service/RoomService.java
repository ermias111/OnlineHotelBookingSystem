package com.example.hbs.service;

import com.example.hbs.domain.*;
import com.example.hbs.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private  RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room createRoom(Integer id , Integer room_number, Boolean vacant, Hotel hotel, RoomType roomType, List<Booking> bookings){
        return roomRepository.findById(id).orElse(roomRepository.save(new Room(room_number, vacant, hotel, roomType,bookings)));
    }

    /**
     * Lookup All Tour packages
     *
     * @return
     */
    public Iterable<Room> lookup(){
        return roomRepository.findAll();
    }

    public long total() {
        return roomRepository.count();
    }
}
