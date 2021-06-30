package com.example.hbs.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AddressTest {
    @Test
    public void testConstructorAndGetters(){

        Address address = new Address("Street", "District", "City", "Postal Code", "Phone");
        assertNull(address.getId());
        assertThat(address.getStreet(), is("Street"));
        assertThat(address.getDistrict(), is("District"));
        assertThat(address.getCity(), is("City"));
        assertThat(address.getPostalCode(), is("Postal Code"));
        assertThat(address.getPhone(), is("Phone"));
    }


    @Test
    public void equalsHashcodeVerify(){
        Address address1 = new Address("Street", "District", "City", "Postal Code", "Phone");
        Address address2 = new Address("Street", "District", "City", "Postal Code", "Phone");

        assertThat(address1, is(address2));
        assertThat(address1.hashCode(), is(address2.hashCode()));
    }
}
