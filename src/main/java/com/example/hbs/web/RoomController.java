package com.example.hbs.web;


import com.example.hbs.domain.Room;
import com.example.hbs.domain.RoomType;
import com.example.hbs.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rooms")
public class RoomController {
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(path = "{roomTypeId}")
    public List<Room> getRoomsByRoomTypeId(@PathVariable("roomTypeId") Integer roomTypeId){
        return roomService.getRoomsByRoomTypeId(roomTypeId);
    }

    @PostMapping(path = "")
    public void addRoomByRoomType(@RequestBody Room room){
        roomService.createRoom(
                room.getRoomNumber(),
                room.getVacant(),
                room.getHotel(),
                room.getRoomType());
    }


}
