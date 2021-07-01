package com.example.hbs.Service;

import com.example.hbs.domain.Account;
import com.example.hbs.domain.Customer;
import com.example.hbs.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AccountServiceIntegrationTest {
    @Autowired
    private AccountService service;
    @Test
    public void signup() {
        Optional<Customer> user = service.signup("dummyUsername", "dummypassword", "john", "doe", "doe@gmail.com");
        assertThat(user.get().getPassword(), not("dummypassword"));
        System.out.println("Encoded Password = " + user.get().getPassword());
    }
}
