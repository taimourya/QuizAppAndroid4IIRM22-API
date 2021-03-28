package com.example.quiz.controller;

import com.example.quiz.dao.UserRepository;
import com.example.quiz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUser(@PathVariable Long id) {

        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }

        return null;
    }

    @PostMapping("/user/create")
    User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

}
