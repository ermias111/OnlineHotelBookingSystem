package com.example.hbs.repo;

import com.example.hbs.domain.Booking;
import com.example.hbs.domain.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends CrudRepository<Booking,Integer> {
    Optional<Booking> findById(String name);

    List<Booking> findByCustomerId(Integer customerId);

    List<Booking> findByRooms_HotelId(Integer hotelId);

    @Override
    Optional<Booking> findById(Integer integer);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    Iterable<Booking> findAll();

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    Iterable<Booking> findAllById(Iterable<Integer> integers);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void deleteById(Integer integer);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void delete(Booking entity);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void deleteAll(Iterable<? extends Booking> entities);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void deleteAll();
}
