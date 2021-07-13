package com.example.hbs.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class BookingTest {
    @Test
    public void testConstructorAndGetters(){
//        Role role = new Role("ROLE_CUSTOMER", "Booking");
//        Role role1 = new Role("ROLE_HOTEL", "The hotel");
//
//        Address address = new Address("Street", "District", "City", "Postal Code", "Phone");
//
//        Hotel hotel = new Hotel("hotel", "hotel123", role1, "My Hotel", "The Hotel", "http//:localhost:8080/images/hotel.png", address);
//
//        RoomType roomType = new RoomType("Standard", "Standard Room", "http//:localhost:8080/images/room.png", 350.00, hotel);
//
//        Customer customer = new Customer("customer", "customer123", role, "Client", "Best", "client@best.com", address);
//
//        List<Room> rooms = new ArrayList<>();
//        rooms.add(new Room(1234,true,hotel,roomType));
//        rooms.add(new Room(1235,true,hotel,roomType));
//
//
//        Date checkIn;
//        Date checkOut = checkIn  = new Date();
//
//        Payment payment = new Payment(customer, "123456789",checkIn,700.00);
//
//        Booking booking = new Booking(checkIn,checkOut ,customer, rooms, payment);
//
//        assertNull(booking.getId());
//        assertThat(booking.getCustomer().getFirstname(), is("Client"));
//        assertThat(booking.getPayment().getPaymentAmount(), is(700.00));
//        assertThat(booking.getRooms().get(0).getRoomType().getType(), is("Standard"));
//        assertThat(booking.getRooms().get(0).getHotel().getName(), is("My Hotel"));

    }

    @Test
    public void equalsHashcodeVerify(){
//        Role role = new Role("ROLE_CUSTOMER", "Booking");
//        Role role1 = new Role("ROLE_HOTEL", "The hotel");
//
//        Address address = new Address("Street", "District", "City", "Postal Code", "Phone");
//
//        Hotel hotel = new Hotel("hotel", "hotel123", role1, "My Hotel", "The Hotel", "http//:localhost:8080/images/hotel.png", address);
//
//        RoomType roomType = new RoomType("Standard", "Standard Room", "http//:localhost:8080/images/room.png", 350.00, hotel);
//
//        Customer customer = new Customer("customer", "customer123", role, "Client", "Best", "client@best.com", address);
//
//        List<Room> rooms = new ArrayList<>();
//        rooms.add(new Room(1234,true,hotel,roomType));
//        rooms.add(new Room(1235,true,hotel,roomType));
//
//
//        Date checkIn = new Date();
//        Date checkOut = checkIn;
//
//        Payment payment = new Payment(customer, "123456789",checkIn,700.00);
//
//        Booking booking1 = new Booking(checkIn,checkOut ,customer, rooms, payment);
//        Booking booking2 = new Booking(checkIn,checkOut ,customer, rooms, payment);
//
//        assertThat(booking1, is(booking2));
//        assertThat(booking1.hashCode(), is(booking2.hashCode()));
    }
}
