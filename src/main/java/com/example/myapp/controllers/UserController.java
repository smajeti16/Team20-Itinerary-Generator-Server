package com.example.myapp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.myapp.models.User;
import com.example.myapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserRepository repository;

    List<User> events = new ArrayList<User>();

    @GetMapping("/api/users") 
    public List<User> findAllUsers() {
        return repository.findAllUsers();
    }

    @GetMapping("/api/users/username/{username}")
    public User findUserByUsername(@PathVariable("username") String username) {
        return repository.findUserByUsername(username);
    }

    @GetMapping("/api/users/username/{username}/password/{password}")
    public User findUserByCredentials(@PathVariable("username") String username, 
                                      @PathVariable("password") String password) {
        return repository.findUserByCredentials(username, password);
    }

    @GetMapping("/api/users/{userId}")
    public User findUserById(@PathVariable("userId") Integer userId) {
        Optional<User> optional = repository.findById(userId);
        return optional.get();
    }

    @DeleteMapping("/api/users/{userId}")
    public List<User> deleteUser(@PathVariable("userId") Integer userId) {
        repository.deleteById(userId);
        return this.findAllUsers();
    }

    @PutMapping("/api/users/{userId}")
    public List<User> updateUser(@PathVariable("userId") Integer userId, @RequestBody User userUpdates) {
        Optional<User> optional = repository.findById(userId);
        User user = optional.get();
        user.setPassword(userUpdates.getPassword());
        repository.save(user);
        return this.findAllUsers();
    }

    @PostMapping("/api/users")
    public List<User> createUser(@RequestBody User user) {
        repository.save(user);
        return this.findAllUsers();
    }
}