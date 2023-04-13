package com.example.clinic.user.modle.dto.response;

import com.example.clinic.user.modle.entity.Role;
import com.example.clinic.user.modle.enums.RoleName;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String phone;
    private Long departmentId;
    private Set<RoleName> roles;
    private boolean isAdmin;
}
