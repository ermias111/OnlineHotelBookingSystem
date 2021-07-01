package com.example.hbs.domain;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class FeedbackTest {

    @Test
    public void testConstructorAndGetters(){
        Role role = new Role("ROLE_HOTEL", "The hotel");
        Role role1 = new Role("ROLE_CUSTOMER", "Booking");
        Address address = new Address("Street", "District", "City", "Postal Code", "Phone");
        Hotel hotel = new Hotel("hotel", "hotel123", role, "My Hotel", "The Hotel", "http//:localhost:8080/images/hotel.png", address);
        Customer customer = new Customer("customer", "customer123", role1, "Client", "Best", "client@best.com");

        Feedback feedback  = new Feedback("Great Hotel", customer,hotel);

        assertNull(feedback.getId());
        assertThat(feedback.getComment(), is("Great Hotel"));
        assertThat(feedback.getCustomer().getFirstname(), is("Client"));
        assertThat(feedback.getHotel().getName(), is("My Hotel"));

    }

    @Test
    public void equalsHashcodeVerify(){
        Role role = new Role("ROLE_HOTEL", "The hotel");
        Role role1 = new Role("ROLE_CUSTOMER", "Booking");
        Address address = new Address("Street", "District", "City", "Postal Code", "Phone");
        Hotel hotel = new Hotel("hotel", "hotel123", role, "My Hotel", "The Hotel", "http//:localhost:8080/images/hotel.png", address);
        Customer customer = new Customer("customer", "customer123", role1, "Client", "Best", "client@best.com");

        Feedback feedback1  = new Feedback("Great Hotel", customer,hotel);
        Feedback feedback2  = new Feedback("Great Hotel", customer,hotel);

        assertThat(feedback1, is(feedback2));
        assertThat(feedback1.hashCode(), is(feedback2.hashCode()));
    }
}
