package com.example.hbs.service;

import com.example.hbs.domain.Hotel;
import com.example.hbs.domain.RoomType;
import com.example.hbs.repo.HotelRepository;
import com.example.hbs.repo.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoomTypeService {
    private RoomTypeRepository roomTypeRepository;
    private HotelRepository hotelRepository;

    @Autowired
    public RoomTypeService(RoomTypeRepository roomTypeRepository, HotelRepository hotelRepository){
        this.roomTypeRepository = roomTypeRepository;
        this.hotelRepository = hotelRepository;
    }

    /**
     * Create new room type
     * @param type
     * @param description
     * @param h
     * @return
     */
    @Transactional
    public RoomType createRoomType(String type, String description, String photoUrl, Double price, Hotel h){
        Hotel hotel = hotelRepository.findById(h.getId()).orElseThrow(() ->
                new RuntimeException("Hotel does not exist"));

        return roomTypeRepository.save(new RoomType(type, description, photoUrl, price, hotel));
    }

    public List<RoomType> getRoomTypesOfAHotel(Integer hotelId){
        return roomTypeRepository.findByHotelId(hotelId);
    }

    public RoomType getRoomTypeById(Integer roomTypeId) {
        RoomType roomType = roomTypeRepository.findById(roomTypeId).orElseThrow(() ->
                    new IllegalStateException("room type doesn't exist")
                );

        return roomType;
    }
}
