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

    @GetMapping("/api/requests/{reqeuestId}")
    public Request findRequestById(@PathVariable("requestId") Integer requestId) {
        Optional<Request> optional = repository.findById(requestId);
        return optional.get();
    }

    @DeleteMapping("/api/requests/{requestId}")
    public List<Request> deleteRequest(@PathVariable("requestId") Integer requestId) {
        repository.deleteById(requestId);
        return this.findAllRequests();
    }

    @PostMapping("/api/requests")
    public List<Request> createRequest(@RequestBody Request request) {
        repository.save(request);
        return this.findAllRequests();
    }

    @PutMapping("/api/requests/{requestId}")
    public List<Request> updateRequest(
        @PathVariable("requestId") Integer requestId, 
        @RequestBody Request requestUpdates) {
        Optional<Request> optional = repository.findById(requestId);
        Request request = optional.get();
        repository.save(request);
        return this.findAllRequests();
    }

}