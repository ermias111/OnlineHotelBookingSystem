package com.example.hbs.repo;

import com.example.hbs.domain.Admin;
import com.example.hbs.domain.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;

public interface AdminRepository  extends CrudRepository<Admin, Integer> {
    Optional<Admin> findByUsername(String userName);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    <S extends Admin> S save(S entity);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    <S extends Admin> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    Optional<Admin> findById(Integer integer);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    boolean existsById(Integer integer);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    Iterable<Admin> findAll();

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    Iterable<Admin> findAllById(Iterable<Integer> integers);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    long count();

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    void deleteById(Integer integer);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    void delete(Admin entity);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    void deleteAll(Iterable<? extends Admin> entities);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    void deleteAll();
}
