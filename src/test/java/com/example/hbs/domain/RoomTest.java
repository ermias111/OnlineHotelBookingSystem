package com.example.hbs.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RoomTest {
    @Test
    public void testConstructorAndGetters(){
        Role role = new Role("ROLE_ADMIN", "Administration");
        Address address = new Address("Street", "District", "City", "Postal Code", "Phone");

        Hotel hotel = new Hotel("hotel", "hotel123", role, "My Hotel", "The Hotel", "http//:localhost:8080/images/hotel.png", address);

        RoomType roomType = new RoomType("Standard", "Standard Room", "http//:localhost:8080/images/room.png", 350.00, hotel);

        Room room = new Room(1234,true,hotel,roomType);

        assertNull(room.getId());
        assertThat(room.getRoomNumber(), is(1234));
        assertThat(room.getVacant(), is(true));
        assertThat(room.getHotel().getName(), is("My Hotel"));
        assertThat(room.getRoomType().getType(), is("Standard"));


    }

    @Test
    public void equalsHashcodeVerify(){
        Role role = new Role("ROLE_ADMIN", "Administration");
        Address address = new Address("Street", "District", "City", "Postal Code", "Phone");

        Hotel hotel = new Hotel("hotel", "hotel123", role, "My Hotel", "The Hotel", "http//:localhost:8080/images/hotel.png", address);

        RoomType roomType = new RoomType("Standard", "Standard Room", "http//:localhost:8080/images/room.png", 350.00, hotel);

        Room room1 = new Room(1234,true,hotel,roomType);
        Room room2 = new Room(12345,true,hotel,roomType);


        assertThat(room1, is(not(room2)));
        assertThat(room1.hashCode(), is(not(room2.hashCode())));
    }
}
