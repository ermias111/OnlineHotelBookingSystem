package com.example.hbs.service;

import com.example.hbs.domain.Account;
import com.example.hbs.domain.Role;
import com.example.hbs.repo.AccountRepository;
import com.example.hbs.repo.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    private AccountRepository accountRepository;

   // private AuthenticationManager authenticationManager;

    private RoleRepository roleRepository;

    //private PasswordEncoder passwordEncoder;

    /**
     * Create a new user in the database.
     *
    // * @param username username
    // * @param password password
     * @return Optional of user, empty if the user already exists.
     */
//    public Optional<Account> signup(String username, String password) {
//        LOGGER.info("New user attempting to sign in");
//        Optional<Account> user = Optional.empty();
//        if (!accountRepository.findByUsername(username).isPresent()) {
//            Optional<Role> role = roleRepository.findByRoleName("ROLE_ADMIN");
//            user = Optional.of(accountRepository.save(new Account(username,
//                    passwordEncoder.encode(password),
//                    role.get())));
//        }
//        return user;
//    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }
}
