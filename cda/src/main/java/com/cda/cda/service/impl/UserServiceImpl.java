package com.cda.cda.service.impl;

import com.cda.cda.dto.users.UserLoginRequest;
import com.cda.cda.dto.users.UserResponse;
import com.cda.cda.dto.users.UserSignUpRequest;
import com.cda.cda.entity.User;
import com.cda.cda.repository.UserRepo;
import com.cda.cda.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserResponse registerUser(UserSignUpRequest userSignUpRequest) {
        User user = modelMapper.map(userSignUpRequest, User.class);
        userRepo.save(user);
        return modelMapper.map(user, UserResponse.class);

    }

    @Override
    public UserResponse loginUser(UserLoginRequest userLoginRequest) {
        User user= userRepo.findByEmail(userLoginRequest.getEmail()).orElseThrow(()->new RuntimeException("User not found"));
        if(user.getPassword().equals(userLoginRequest.getPassword())){
            return modelMapper.map(user, UserResponse.class);
        }
        throw new RuntimeException("Invalid password");
    }
}
