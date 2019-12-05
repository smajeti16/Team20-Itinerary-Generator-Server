package com.example.myapp.controllers;

import java.util.ArrayList;
import java.util.List;
import com.example.myapp.models.Request;
import com.example.myapp.repositories.RequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class RequestController {
    @Autowired
    RequestRepository repository;

    List<Request> requests = new ArrayList<Request>();

    @GetMapping("/api/requests") 
    public List<Request> findAllRequests() {
        return repository.findAllRequests();
    }

}