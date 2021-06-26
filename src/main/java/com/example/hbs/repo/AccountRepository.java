package com.example.hbs.repo;

import com.example.hbs.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByUsername(String userName);

}
