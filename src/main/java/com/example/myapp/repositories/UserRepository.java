package com.example.myapp.repositories;
import com.example.myapp.models.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Integer> {
    // @Query("SELECT user FROM User user")
    // public List<User> findAllUsers();

    @Query("SELECT user FROM User user WHERE user.username=:username")
    public User findUserByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE u.username=:username AND u.password=:password")
    public User findUserByCredentials(
        @Param("username") String username,
        @Param("password") String password);

    @Query("SELECT u FROM User u WHERE u.id=:userId")
    public User findUserById(@PathVariable("userId") Integer userId);

    @Query("DELETE FROM User u WHERE u.id=:userId")
    public List<User> deleteUser(@PathVariable("userId") Integer userId);

    // @Query("UPDATE User u SET u.id=:userUpdates.id AND      WHERE u.id=:userId")
    // public List<User> updateUser(@PathVariable("userId") Integer userId, 
    //                              @RequestBody User userUpdates);
}