package com.example.hbs.service;

import com.example.hbs.domain.*;
import com.example.hbs.repo.AccountRepository;
import com.example.hbs.repo.CustomerRepository;
import com.example.hbs.repo.HotelRepository;
import com.example.hbs.repo.RoleRepository;
import com.example.hbs.security.JwtProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    private AccountRepository accountRepository;

    private AuthenticationManager authenticationManager;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    private JwtProvider jwtProvider;

    private  CustomerRepository customerRepository;

    @Autowired

    public AccountService(AccountRepository accountRepository, AuthenticationManager authenticationManager, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.authenticationManager = authenticationManager;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
        this.customerRepository = customerRepository;
    }



    /**
     * Sign in a user into the application, with JWT-enabled authentication
     *
     * @param username  username
     * @param password  password
     * @return Optional of the Java Web Token, empty otherwise
     */
    public Optional<String> signin(String username, String password) {
        LOGGER.info("New user attempting to sign in");
        Optional<String> token = Optional.empty();
        Optional<Account> user = accountRepository.findByUsername(username);
        if (user.isPresent()) {
            try {

                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
                token = Optional.of(jwtProvider.createToken(username, Arrays.asList(user.get().getRole())));
            } catch (AuthenticationException e){
                LOGGER.info("Log in failed for user {}", username);
            }
        }
        return token;
    }

    /**
     * Create a new user in the database.
     *
    // * @param username username
    // * @param password password
     * @return Optional of user, empty if the user already exists.
     */
    public Optional<Customer> signup(String username, String password, String firstname, String lastname,String email) {
        LOGGER.info("New user attempting to sign in");
        Optional<Customer> user = Optional.empty();
        Optional<Customer> customer = customerRepository.findByEmail(email);
        if(customer.isPresent()){
            throw new IllegalStateException("Email must be unique");
        }

        if (!accountRepository.findByUsername(username).isPresent()) {
            Optional<Role> role = roleRepository.findByRoleName("Customer");
            user = Optional.of(accountRepository.save(new Customer(username,
                    passwordEncoder.encode(password),
                    role.get(),
                    firstname,
                    lastname,
                    email)));
        }
        return user;
    }

    public Optional<Hotel> signupH(String username, String password, String name, String description,String photoUrl,Address address) {
        LOGGER.info("New user attempting to sign in");
        Optional<Hotel> user = Optional.empty();
        if (!accountRepository.findByUsername(username).isPresent()) {
            Optional<Role> role = roleRepository.findByRoleName("Hotel");
            user = Optional.of(accountRepository.save(new Hotel(username,
                    passwordEncoder.encode(password),
                    role.get(),
                    name,
                    description,
                    photoUrl,
                    address)));
        }
        return user;
    }

    public Optional<Admin> signupA(String username, String password) {
        LOGGER.info("New user attempting to sign in");
        Optional<Admin> user = Optional.empty();
        if (!accountRepository.findByUsername(username).isPresent()) {
            Optional<Role> role = roleRepository.findByRoleName("Admin");
            user = Optional.of(accountRepository.save(new Admin(username,
                    passwordEncoder.encode(password),
                    role.get())));
        }
        return user;
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

}
