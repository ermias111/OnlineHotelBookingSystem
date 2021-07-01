package com.example.hbs.Service;


import com.example.hbs.domain.*;
import com.example.hbs.service.RoomService;
import com.example.hbs.web.BookingDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RoomServiceIntegrationTest {
    @Autowired
    private RoomService roomService;

    Role role = new Role("Hotel", "Hotel role");
    Address address = new Address("5th st", "IA", "Otu", "1234", "+9883..");
    Hotel hotel = new Hotel("Hotel Y", "5 star", "/img/ds.jpg", address);
    RoomType standard = new RoomType("Standard", "3 bed room", "img/dk.jpg", 230.0, hotel);
    Room roomT = new Room(200, true, hotel, standard);

    @Test
    public void createRoom(){
        Room room = roomService.createRoom(200, true, hotel, standard);
        assertThat(room.getRoomNumber(), is(roomT.getRoomNumber()));
        assertThat(room.getVacant(), is(roomT.getVacant()));
        assertThat(room.getHotel(), is(roomT.getHotel()));
        assertThat(room.getRoomType(), is(roomT.getRoomType()));
    }

    @Test
    public void bookRoom(){
        Room room = roomService.createRoom(200, true, hotel, standard);
        roomService.bookRoom(room.getId());
        assertThat(room.getVacant(), is(false));
    }

    @Test
    public void freeRoom(){
        Room room = roomService.createRoom(200, true, hotel, standard);
        roomService.freeRoom(room.getId());
        assertThat(room.getVacant(), is(true));
    }

}
