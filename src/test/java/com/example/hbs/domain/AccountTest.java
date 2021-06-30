package com.example.hbs.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class AccountTest {

    @Test
    public void testConstructorAndGetters(){
        Role role = new Role("ROLE_ADMIN", "Administration");
        Account account = new Account("admin","admin123", role);
        assertNull(account.getId());
        assertThat(account.getUsername(), is("admin"));
        assertThat(account.getPassword(), is("admin123"));
        assertThat(account.getRole().getRoleName(), is(role.getRoleName()));

    }

    @Test
    public void equalsHashcodeVerify(){
        Role role = new Role("ROLE_ADMIN", "Administration");
        Account account1 = new Account("admin","admin123", role);
        Account account2 = new Account("admin","admin123", role);
        assertThat(account1, is(account2));
        assertThat(account1.hashCode(), is(account2.hashCode()));
    }
}
