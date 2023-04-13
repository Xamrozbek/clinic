package com.example.clinic.user.controller;

import com.example.clinic.department.service.DepartmentService;
import com.example.clinic.user.mapper.UserMapper;
import com.example.clinic.user.modle.dto.request.UserRegistrationRequest;
import com.example.clinic.user.modle.dto.response.ApiResponse;
import com.example.clinic.user.modle.dto.response.UserResponse;
import com.example.clinic.user.modle.entity.User;
import com.example.clinic.user.service.RoleService;
import com.example.clinic.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;
    private final DepartmentService departmentService;

    @GetMapping("/me")
    public UserResponse findByUsername(@RequestParam("username") String username) {
        User user = userService.findByUsername(username).orElseThrow(
                () -> new RuntimeException("User not found username " + username)
        );

        return UserMapper.userToUserResponse(user);
    }

    @GetMapping("/list")
    public List<UserResponse> findAll() {
        return UserMapper.usersToUserResponses(userService.findAll());
    }

    @PostMapping(value = "/register")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> register(@RequestBody UserRegistrationRequest userRegistrationRequest) {

        if (userService.findByUsername(userRegistrationRequest.getUsername()).isPresent()) {
            return new ResponseEntity<>(new ApiResponse(false, "Username already exists!", null), HttpStatus.CONFLICT);
        }
        return null;
    }
}
