package com.example.hbs.service;

import com.example.hbs.domain.*;
import com.example.hbs.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private  RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room createRoom(Integer id, String description, String photoUrl, Double price, Boolean vacant, Hotel hotel, RoomType roomType){
        return roomRepository.findById(id).orElse(roomRepository.save(new Room(id,description,photoUrl,price,vacant,hotel,roomType)));
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
