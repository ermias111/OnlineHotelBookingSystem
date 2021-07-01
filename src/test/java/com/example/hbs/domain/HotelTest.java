package com.example.hbs.domain;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class HotelTest {
    @Test
    public void testConstructorAndGetters(){
        Role role = new Role("ROLE_HOTEL", "The hotel");

        Address address = new Address("Street", "District", "City", "Postal Code", "Phone");
        Hotel hotel = new Hotel("hotel", "hotel123", role, "My Hotel", "The Hotel", "http//:localhost:8080/images/hotel.png", address);

        assertNull(hotel.getId());
        assertThat(hotel.getUsername(), is("hotel"));
        assertThat(hotel.getPassword(), is("hotel123"));
        assertThat(hotel.getRole().getRoleName(), is(role.getRoleName()));
        assertThat(hotel.getName(), is("My Hotel"));
        assertThat(hotel.getDescription(), is("The Hotel"));
        assertThat(hotel.getPhotoUrl(), is("http//:localhost:8080/images/hotel.png"));
        assertThat(hotel.getAddress().getCity(), is(address.getCity()));

    }

    @Test
    public void equalsHashcodeVerify(){
        Role role = new Role("ROLE_HOTEL", "The hotel");

        Address address = new Address("Street", "District", "City", "Postal Code", "Phone");
        Hotel hotel1 = new Hotel("hotel", "hotel123", role, "My Hotel", "The Hotel", "http//:localhost:8080/images/hotel.png", address);
        Hotel hotel2 = new Hotel("hotel", "hotel123", role, "My Hotel", "The Hotel", "http//:localhost:8080/images/hotel.png", address);
        assertThat(hotel1, is(hotel2));
        assertThat(hotel1.hashCode(), is(hotel2.hashCode()));
    }
}
