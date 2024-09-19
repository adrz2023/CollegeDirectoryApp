package com.cda.cda.service;

import com.cda.cda.dto.users.UserLoginRequest;
import com.cda.cda.dto.users.UserResponse;
import com.cda.cda.dto.users.UserSignUpRequest;

public interface UserService {
    UserResponse registerUser(UserSignUpRequest userSignUpRequest);

    UserResponse loginUser(UserLoginRequest userLoginRequest);
}
