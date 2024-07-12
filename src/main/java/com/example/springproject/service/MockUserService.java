package com.example.springproject.service;

import com.example.springproject.model.request.CreateUserRequest;
import com.example.springproject.model.request.UserCriteria;
import com.example.springproject.model.response.CreateUserResponse;
import com.example.springproject.model.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@Profile("default")
public class MockUserService implements UserService{
    @Override
    public CreateUserResponse createUser(CreateUserRequest userRequest) {
        return new CreateUserResponse("Hello from test environment");
    }

    @Override
    public void updateUser(String userId, Integer age) {
        System.out.println("Hello from test environment");
    }

    @Override
    public List<UserResponse> getUser(UserCriteria userCriteria) {
        return new ArrayList<>();
    }

}
