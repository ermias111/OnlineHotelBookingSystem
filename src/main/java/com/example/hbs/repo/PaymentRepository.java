package com.example.hbs.repo;

import com.example.hbs.domain.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    Optional<Payment> findById(Integer integer);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    Iterable<Payment> findAll();

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    Iterable<Payment> findAllById(Iterable<Integer> integers);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void deleteById(Integer integer);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void delete(Payment entity);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void deleteAll(Iterable<? extends Payment> entities);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void deleteAll();
}
