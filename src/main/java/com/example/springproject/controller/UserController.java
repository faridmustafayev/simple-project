package com.example.springproject.controller;

import com.example.springproject.model.User;
import com.example.springproject.model.request.CreateUserRequest;
import com.example.springproject.model.request.UserCriteria;
import com.example.springproject.model.response.CreateUserResponse;
import com.example.springproject.model.response.UserResponse;
import com.example.springproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userServiceImpl;

//    public UserController(@Qualifier("userServiceImpl") UserService userService) {
//        this.userService = userService;
//    }

    @PostMapping
    @ResponseStatus(CREATED)
    public CreateUserResponse createUser(@RequestBody CreateUserRequest userRequest) {
        return userServiceImpl.createUser(userRequest);
    }

    @PatchMapping("/{userId}")
    @ResponseStatus(NO_CONTENT)
    public void updateUser(@PathVariable String userId,
                           @RequestParam Integer age) {
        userServiceImpl.updateUser(userId, age);
    }

    @GetMapping
    public List<UserResponse> getUser(UserCriteria userCriteria) {
        return userServiceImpl.getUser(userCriteria);
    }

}