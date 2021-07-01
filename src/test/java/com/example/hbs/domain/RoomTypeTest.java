package com.example.hbs.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RoomTypeTest {
    @Test
    public void testConstructorAndGetters(){
        Role role = new Role("ROLE_ADMIN", "Administration");
        Address address = new Address("Street", "District", "City", "Postal Code", "Phone");

        Hotel hotel = new Hotel("hotel", "hotel123", role, "My Hotel", "The Hotel", "http//:localhost:8080/images/hotel.png", address);

        RoomType roomType = new RoomType("Standard", "Standard Room", "http//:localhost:8080/images/room.png", 350.00, hotel);


        assertNull(roomType.getId());
        assertThat(roomType.getType(), is("Standard"));
        assertThat(roomType.getDescription(), is("Standard Room"));
        assertThat(roomType.getPhotoUrl(), is("http//:localhost:8080/images/room.png"));
        assertThat(roomType.getPrice(), is(350.00));
        assertThat(roomType.getHotel().getName(), is("My Hotel"));



    }

    @Test
    public void equalsHashcodeVerify(){
        Role role = new Role("ROLE_ADMIN", "Administration");
        Address address = new Address("Street", "District", "City", "Postal Code", "Phone");

        Hotel hotel = new Hotel("hotel", "hotel123", role, "My Hotel", "The Hotel", "http//:localhost:8080/images/hotel.png", address);

        RoomType roomType1 = new RoomType("Royal", "Standard Room", "http//:localhost:8080/images/room.png", 350.00, hotel);
        RoomType roomType2 = new RoomType("Standard", "Standard Room", "http//:localhost:8080/images/room.png", 350.00, hotel);


        assertThat(roomType1, is(not(roomType2)));
        assertThat(roomType1.hashCode(), is(not(roomType2.hashCode())));
    }
}
