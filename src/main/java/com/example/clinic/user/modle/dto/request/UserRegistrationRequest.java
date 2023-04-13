package com.example.clinic.user.modle.dto.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserRegistrationRequest {
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String firstname;
    @NonNull
    private String lastname;
    @NonNull
    private String phone;
    @NonNull
    private Long departmentId;
}
