package com.example.hbs.web;


import com.example.hbs.domain.Room;
import com.example.hbs.domain.RoomType;
import com.example.hbs.service.RoomService;
import com.example.hbs.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/roomTypes")
public class RoomTypeController {
    private RoomTypeService roomTypeService;

    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @GetMapping(path = "{roomTypeId}")
    public RoomType getRoomTypeById(@PathVariable("roomTypeId") Integer roomTypeId){
        return roomTypeService.getRoomTypeById(roomTypeId);
    }


    @GetMapping(path = "{hotelId}")
    public List<RoomType> getRoomsTypesByHotelId(@PathVariable("hotelId") Integer hotelId){
        return roomTypeService.getRoomTypesOfAHotel(hotelId);
    }

    @PostMapping(path = "")
    public void addRoomTypeByHotel(@RequestBody RoomType roomType){
        roomTypeService.createRoomType(
                roomType.getType(),
                roomType.getDescription(),
                roomType.getPhotoUrl(),
                roomType.getPrice(),
                roomType.getHotel()
                );
    }




}
