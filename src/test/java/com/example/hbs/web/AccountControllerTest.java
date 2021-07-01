package com.example.hbs.web;

import com.example.hbs.domain.Account;
import com.example.hbs.domain.Customer;
import com.example.hbs.domain.Role;
import com.example.hbs.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {

    private LoginDto signupDto = new LoginDto("ray100", "r@y100", "Raymond", "Jean", "ray@gmail.com");
    private Customer user = new Customer(signupDto.getUsername(), signupDto.getPassword(), new Role(),
            signupDto.getFirstname(), signupDto.getLastname());

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private JwtRequestHelper jwtRequestHelper;

    @MockBean
    private AccountService service;


    @Test
    public void signin() {
        restTemplate.postForEntity("/accounts/signin", new LoginDto("myHotel", "r@y100"), Void.class);
        verify(this.service).signin("myHotel","r@y100");
    }

    @Test
    public void signup(){
        when(service.signup(signupDto.getUsername(), signupDto.getPassword(), signupDto.getFirstname(),
                signupDto.getLastname(), signupDto.getEmail())).thenReturn(Optional.of(user));

        ResponseEntity<Customer> response = restTemplate.exchange("/accounts/signup/customer",
                POST,
                new HttpEntity(signupDto,jwtRequestHelper.withRole("ROLE_ADMIN")),
                Customer.class);

        assertThat(response.getStatusCode().value(), is(201));
        assertThat(response.getBody().getUsername(), is(user.getUsername()));
        assertThat(response.getBody().getFirstname(), is(user.getFirstname()));
        assertThat(response.getBody().getLastname(), is(user.getLastname()));
        assertThat(response.getBody().getRole(), is(user.getRole()));
    }

//    @Test
//    public void signupUnauthorized(){
//
//        ResponseEntity<Customer> response = restTemplate.exchange("/accounts/signup/customer",
//                POST,
//                new HttpEntity(signupDto,jwtRequestHelper.withRole("Customer")),
//                Customer.class);
//
//        assertThat(response.getStatusCode().value(), is(403));
//    }

    @Test
    public void getAllUsers() {
        when(service.getAll()).thenReturn(Arrays.asList(user));

        ResponseEntity<List<Customer>> response = restTemplate.exchange("/accounts",
                GET,
                new HttpEntity(jwtRequestHelper.withRole("Customer")),
                new ParameterizedTypeReference<List<Customer>>() {});

        assertThat(response.getStatusCode().value(), is(200));
        assertThat(response.getBody().get(0).getUsername(), is(user.getUsername()));
    }
}
