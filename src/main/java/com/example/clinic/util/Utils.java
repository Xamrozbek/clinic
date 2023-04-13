package com.example.clinic.util;

import com.example.clinic.user.modle.entity.User;
import com.example.clinic.user.modle.enums.RoleName;
import lombok.experimental.UtilityClass;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class Utils {

    public static boolean isAdmin(Optional<User> userOptional) {
        return userOptional.get().getRoles().stream()
                .anyMatch(role -> role.getName().name().equals(RoleName.ROLE_ADMIN.name()));
    }

    public static Set<RoleName> getUserRoles(final User user) {
        return user.getRoles().stream()
                .map(role -> role.getName())
                .collect(Collectors.toSet());
    }
}
