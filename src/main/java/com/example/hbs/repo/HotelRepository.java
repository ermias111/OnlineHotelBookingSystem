package com.example.hbs.repo;

import com.example.hbs.domain.Account;
import com.example.hbs.domain.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {
    List<Hotel> findByAddressCity(String name);
    List<Hotel> findByAddress_District(String district);
    Optional<Hotel> findByUsername(String userName);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    <S extends Hotel> S save(S entity);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    <S extends Hotel> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    void deleteById(Integer integer);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    void delete(Hotel entity);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    void deleteAll(Iterable<? extends Hotel> entities);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    void deleteAll();
}
