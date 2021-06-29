package com.example.hbs.web;

import com.example.hbs.domain.Account;
import com.example.hbs.domain.Payment;
import com.example.hbs.service.AccountService;
import com.example.hbs.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    PaymentService paymentService;

    @PostMapping("/signin")
    public String login(@RequestBody @Valid LoginDto loginDto){
        return accountService.signin(loginDto.getUsername(), loginDto.getPassword()).orElseThrow(()->
                new HttpServerErrorException(HttpStatus.FORBIDDEN, "Login Failed"));
    }

    @PostMapping("/signup/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public Account signup(@RequestBody @Valid LoginDto loginDto){
        return accountService.signup(loginDto.getUsername(), loginDto.getPassword(), loginDto.getFirstname(),
                loginDto.getLastname(),loginDto.getEmail()).orElseThrow(() -> new HttpServerErrorException(HttpStatus.BAD_REQUEST,"User already exists"));
    }

    @PostMapping("/signup/hotel")
    @ResponseStatus(HttpStatus.CREATED)
    public Account signupH(@RequestBody @Valid LoginDto loginDto){
        LOGGER.info("address" + loginDto.getAddress());
        return accountService.signupH(loginDto.getUsername(), loginDto.getPassword(),
               loginDto.getName(),loginDto.getDescription(),loginDto.getPhotoUrl(), loginDto.getAddress()).orElseThrow(() -> new HttpServerErrorException(HttpStatus.BAD_REQUEST,"User already exists"));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('Admin')")
    public List<Account> getAllUsers() {
        return accountService.getAll();
    }
}
