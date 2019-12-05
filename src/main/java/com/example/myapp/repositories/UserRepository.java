package com.example.myapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.example.myapp.models.User;


public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT user FROM User user")
    public List<User> findAllUsers();
}