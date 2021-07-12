package com.example.hbs.web;

import com.example.hbs.domain.Account;
import com.example.hbs.domain.Address;
import com.example.hbs.domain.Payment;
import com.example.hbs.service.AccountService;
import com.example.hbs.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

import static com.example.hbs.web.LoginDto.validate;

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

        if (!validate(loginDto.getEmail()))
            throw new IllegalArgumentException("Email is not valid");
        else  if (loginDto.getUsername()==null|| loginDto.getUsername().isEmpty()){
            throw new IllegalArgumentException("Username is not valid");

        }
        else
        return accountService.signup(loginDto.getUsername(), loginDto.getPassword(), loginDto.getFirstname(),
                loginDto.getLastname(),loginDto.getEmail()).orElseThrow(()
                -> new HttpServerErrorException(HttpStatus.BAD_REQUEST,"User already exists"));
    }

    @PostMapping("/signup/hotel")
    @ResponseStatus(HttpStatus.CREATED)
    public Account signupH(@RequestBody @Valid LoginDto loginDto){
//        if (loginDto.getAddress()!=null){
//            Address address=loginDto.getAddress();
//            if (!LoginDto.valid_num(address.getPhone(),10)){
//                throw new IllegalArgumentException("Phone number is not valid");
//
//            }
//
//            if (!LoginDto.valid_num(address.getPostalCode(),5)){
//                throw new IllegalArgumentException("Postal number  is not valid");
//
//            }
//
//        }
//        else {
//            throw new IllegalArgumentException("Address information is not valid");
//
//        }

        LOGGER.info("address" + loginDto.getAddress());
        if (loginDto.getUsername()==null|| loginDto.getUsername().isEmpty()){
            throw new IllegalArgumentException("Username is not valid");
        }

        return accountService.signupH(loginDto.getUsername(), loginDto.getPassword(),
               loginDto.getName(),loginDto.getDescription(),loginDto.getPhotoUrl(), loginDto.getAddress()).orElseThrow(() -> new HttpServerErrorException(HttpStatus.BAD_REQUEST,"User already exists"));
    }

    @PostMapping("/signup/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public Account signupA(@RequestBody @Valid LoginDto loginDto){
        return accountService.signupA(loginDto.getUsername(), loginDto.getPassword()).orElseThrow(() -> new HttpServerErrorException(HttpStatus.BAD_REQUEST,"User already exists"));
    }

    @GetMapping("/logout")
    public String signout(){
        return "logout";
    }

    @GetMapping
    @PreAuthorize("hasAuthority('Admin')")
    public List<Account> getAllUsers() {
        return accountService.getAll();
    }
}
