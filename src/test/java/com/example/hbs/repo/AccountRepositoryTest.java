package com.example.hbs.repo;

import com.example.hbs.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {
    @Autowired AccountRepository repository;

    @Test
    public void testFindByUsername(){
        Optional<Account> user = repository.findByUsername("hotel");
        assertTrue(user.isPresent());

        user = repository.findByUsername("admin");
        assertFalse(user.isPresent());
    }
}
