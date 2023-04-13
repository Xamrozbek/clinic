package com.example.clinic.user.modle.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse {
    private boolean success;
    private String massage;
    private Object data;
}
