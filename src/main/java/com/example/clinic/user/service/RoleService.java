package com.example.clinic.user.service;

import com.example.clinic.user.modle.entity.Role;
import com.example.clinic.user.modle.enums.RoleName;
import com.example.clinic.user.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role findByName(RoleName name) {
        return roleRepository.findByName(name.name())
                .orElseThrow(() -> new RuntimeException("role by name" + name.name() + " not found"));
    }

}
