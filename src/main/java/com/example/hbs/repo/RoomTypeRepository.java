package com.example.hbs.repo;

import com.example.hbs.domain.RoomType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

public interface RoomTypeRepository extends CrudRepository<RoomType, Integer> {
    Optional<RoomType> findByType(String type);

    List<RoomType> findByHotelId(Integer hotelId);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    <S extends RoomType> S save(S entity);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    <S extends RoomType> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void deleteById(Integer integer);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void delete(RoomType entity);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void deleteAll(Iterable<? extends RoomType> entities);

    @Override
    @PreAuthorize("hasAuthority('Hotel')")
    void deleteAll();
}
