package com.example.springproject.service;

import com.example.springproject.model.User;
import com.example.springproject.model.request.CreateUserRequest;
import com.example.springproject.model.request.UserCriteria;
import com.example.springproject.model.response.CreateUserResponse;
import com.example.springproject.model.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
//@Primary
//@Profile("!default")
public class UserServiceImpl implements UserService {
    private final Map<String, User> userMap = new HashMap<>();

    @Override
    public CreateUserResponse createUser(CreateUserRequest userRequest) {
        var randomId = UUID.randomUUID().toString();
        userMap.put(randomId, new User(randomId, userRequest.getName(), userRequest.getAge()));
        return new CreateUserResponse(randomId);
    }

    @Override
    public void updateUser(String userId, Integer age) {
        var existingUser = userMap.get(userId);
        if (existingUser != null) {
            existingUser.setAge(age);
        }else {
            System.out.println("User not found in map");
            throw new RuntimeException("User not found in map");
        }
        userMap.put(userId, existingUser);
    }

    @Override
    public List<UserResponse> getUser(UserCriteria userCriteria) {
        Predicate<User> predicate1 = it-> it.getAge() > userCriteria.getFromAge();
        Predicate<User> predicate2 = it-> it.getAge() <= userCriteria.getToAge();

        return userMap.values()
                .stream()
                .filter(user -> predicate1.test(user) && predicate2.test(user))
                .map(this::buildUserResponse)
                .collect(Collectors.toList());
    }

    private UserResponse buildUserResponse(User user) {
        return new UserResponse(user.getId(), user.getName());
    }

}
