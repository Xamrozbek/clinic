package com.example.clinic.user.modle.dto.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class UpdateUserRequest {

    @NonNull
    Long id;
    @NonNull
    String password;
    @NonNull
    String firstname;
    @NonNull
    String lastname;
    @NonNull
    String phone;
    @NonNull
    Long departmentId;

}
