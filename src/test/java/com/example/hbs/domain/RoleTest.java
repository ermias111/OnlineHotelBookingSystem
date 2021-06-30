package com.example.hbs.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class RoleTest {
    @Test
    public void testConstructorAndGetters(){
        Role role = new Role("ROLE_ADMIN", "Administration");
        assertNull(role.getId());
        assertThat(role.getRoleName(), is("ROLE_ADMIN"));
        assertThat(role.getDescription(), is("Administration"));


    }

    @Test
    public void equalsHashcodeVerify(){
        Role role1 = new Role("ROLE_ADMIN", "Administration");
        Role role2 = new Role("ROLE_ADMIN", "Administration");

        assertThat(role1, is(role2));
        assertThat(role1.hashCode(), is(role2.hashCode()));
    }
}
