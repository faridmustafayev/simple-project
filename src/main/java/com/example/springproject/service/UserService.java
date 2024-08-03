package com.example.springproject.service;

import com.example.springproject.model.request.CreateUserRequest;
import com.example.springproject.model.request.UserCriteria;
import com.example.springproject.model.response.CreateUserResponse;
import com.example.springproject.model.response.UserResponse;

import java.util.List;

public interface UserService {
    CreateUserResponse createUser(CreateUserRequest userRequest);
    void updateUser(String userId, Integer age);
    List<UserResponse> getUser(UserCriteria userCriteria);
}
