package com.example.hbs.service;

import com.example.hbs.domain.Role;
import com.example.hbs.repo.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(String name, String description){

        return roleRepository.findByRoleName(name).orElse(roleRepository.save(new Role(name, description)));
    }
}
