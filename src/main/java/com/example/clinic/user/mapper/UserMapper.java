package com.example.clinic.user.mapper;

import com.example.clinic.user.modle.dto.response.UserResponse;
import com.example.clinic.user.modle.entity.User;
import com.example.clinic.util.Utils;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Optional;

@UtilityClass
public class UserMapper {

    public UserResponse userToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstname(user.getFirstName())
                .lastname(user.getLastName())
                .phone(user.getPhone())
                .departmentId(user.getDepartmentId())
                .roles(Utils.getUserRoles(user))
                .isAdmin(Utils.isAdmin(Optional.of(user)))
                .build();
    }

    public static List<UserResponse> usersToUserResponses(List<User> list) {
        return list.stream()
                .map(UserMapper::userToUserResponse)
                .sorted((c1, c2) -> Long.compare(c2.getId(), c1.getId()))
                .toList();
    }
}
