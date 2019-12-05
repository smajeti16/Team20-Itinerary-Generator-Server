package com.example.myapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.example.myapp.models.Request;

public interface RequestRepository extends CrudRepository<Request, Integer> {
    @Query("SELECT request FROM Request request")
    public List<Request> findAllRequests();
}