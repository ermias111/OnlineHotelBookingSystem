package com.example.hbs.Service;


import com.example.hbs.domain.*;
import com.example.hbs.service.RoomService;
import com.example.hbs.web.BookingDto;
import com.example.hbs.web.JwtRequestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpMethod.POST;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RoomServiceIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private JwtRequestHelper jwtRequestHelper;

    @Autowired
    private RoomService roomService;

    private static final String ROOMS_URL = "/rooms/";


    Role role = new Role("Hotel", "Hotel role");
    Address address = new Address("5th st", "IA", "Otu", "1234", "+9883..");
    Hotel hotel = new Hotel("Hotel Y", "5 star", "/img/ds.jpg", address);
    RoomType standard = new RoomType("Standard", "3 bed room", "img/dk.jpg", 230.0, hotel);
    Room roomT = new Room(200, true, hotel, standard);

    @Test
    public void createRoom(){
//        restTemplate.exchange(ROOMS_URL, POST,
//                new HttpEntity(roomT, jwtRequestHelper.withRole(role.getRoleName())),
//                Void.class);
//
//        verify(this.roomService).createRoom(200, true, hotel, standard);

//        Room room = roomService.createRoom(200, true, hotel, standard);
//        assertThat(room.getRoomNumber(), is(roomT.getRoomNumber()));
//        assertThat(room.getVacant(), is(roomT.getVacant()));
//        assertThat(room.getHotel(), is(roomT.getHotel()));
//        assertThat(room.getRoomType(), is(roomT.getRoomType()));

        restTemplate.exchange(ROOMS_URL, POST,
                new HttpEntity(roomT, jwtRequestHelper.withRole("Hotel")),
                Void.class);

        verify(this.roomService).createRoom(200, true, hotel, standard);

    }

    @Test
    public void bookRoom(){
        Room room = roomService.createRoom(200, true, hotel, standard);
        roomService.bookRoom(room.getId());
        assertThat(room.getVacant(), is(false));
    }

    @Test
    public void freeRoom(){
        Room room = roomService.createRoom(200, false, hotel, standard);
        roomService.freeRoom(room.getId());
        assertThat(room.getVacant(), is(true));
    }

}
