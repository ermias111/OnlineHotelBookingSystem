package com.example.hbs.repo;

import com.example.hbs.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(String name);

    @Override
    <S extends Role> List<S> saveAll(Iterable<S> entities);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    <S extends Role> S saveAndFlush(S entity);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    <S extends Role> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    void deleteAllInBatch(Iterable<Role> entities);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    void deleteAllInBatch();

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    <S extends Role> S save(S entity);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    void deleteById(Long aLong);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    void delete(Role entity);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    void deleteAll(Iterable<? extends Role> entities);

    @Override
    @PreAuthorize("hasAuthority('Admin')")
    void deleteAll();
}
