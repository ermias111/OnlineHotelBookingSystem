package com.example.hbs.repo;

import com.example.hbs.domain.Room;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends PagingAndSortingRepository<Room, Integer> {

    List<Room> findByRoomTypeIdAndVacantTrue(Integer roomTypeId);

    @Override
    Optional<Room> findById(Integer integer);

    Optional<Room> findByRoomTypeIdAndRoomNumber(Integer roomTypeId, Integer roomNumber);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    <S extends Room> S save(S entity);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    <S extends Room> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void deleteById(Integer integer);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void delete(Room entity);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void deleteAll(Iterable<? extends Room> entities);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void deleteAll();
}
