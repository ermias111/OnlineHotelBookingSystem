package com.example.hbs.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class CustomerTest {


    @Test
    public void testConstructorAndGetters(){
        Role role = new Role("ROLE_CUSTOMER", "Booking");

        Customer customer = new Customer("customer", "customer123", role, "Client", "Best", "client@best.com");

        assertNull(customer.getId());
        assertThat(customer.getUsername(), is("customer"));
        assertThat(customer.getPassword(), is("customer123"));
        assertThat(customer.getRole().getRoleName(), is(role.getRoleName()));
        assertThat(customer.getFirstname(), is("Client"));
        assertThat(customer.getLastname(), is("Best"));
        assertThat(customer.getEmail(), is("client@best.com"));

    }

    @Test
    public void equalsHashcodeVerify(){
        Role role = new Role("ROLE_ADMIN", "Administration");
        Customer customer1 = new Customer("customer", "customer123", role, "Client", "Best", "client@best.com");
        Customer customer2 = new Customer("customer", "customer123", role, "Client", "Best", "client@best.com");
        assertThat(customer1, is(customer2));
        assertThat(customer1.hashCode(), is(customer2.hashCode()));
    }

}
