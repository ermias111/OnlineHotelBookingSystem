package com.example.hbs.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class PaymentTest {
//    @Test
//    public void testConstructorAndGetters(){
//        Role role = new Role("ROLE_CUSTOMER", "Booking");
//        Customer customer = new Customer("customer", "customer123", role, "Client", "Best", "client@best.com");
//
//        Date checkIn;
//        Date checkOut = checkIn  = new Date();
//
//        Payment payment = new Payment(customer, "123456789",checkIn,700.00);
//
//        assertNull(payment.getId());
//        assertThat(payment.getCardHolder().getFirstname(), is("Client"));
//        assertThat(payment.getCardNum(), is("123456789"));
//        assertThat(payment.getPaymentAmount(), is(700.00));
//
//    }
//
//    @Test
//    public void equalsHashcodeVerify(){
//        Role role = new Role("ROLE_CUSTOMER", "Booking");
//        Customer customer = new Customer("customer", "customer123", role, "Client", "Best", "client@best.com");
//
//        Date checkIn;
//        Date checkOut = checkIn  = new Date();
//
//        Payment payment1 = new Payment(customer, "123456789",checkIn,700.00);
//        Payment payment2 = new Payment(customer, "123456789",checkIn,700.00);
//
//        assertThat(payment1, is(payment2));
//        assertThat(payment1.hashCode(), is(payment2.hashCode()));
//    }
}
