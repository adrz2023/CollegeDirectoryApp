package com.cda.cda.controller;

import com.cda.cda.dto.users.UserLoginRequest;
import com.cda.cda.dto.users.UserResponse;
import com.cda.cda.dto.users.UserSignUpRequest;
import com.cda.cda.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserSignUpRequest userSignUpRequest) {
        return ResponseEntity.status(201).body(userService.registerUser(userSignUpRequest));
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest userLoginRequest) {
        return ResponseEntity.status(200).body(userService.loginUser(userLoginRequest));
    }

}
