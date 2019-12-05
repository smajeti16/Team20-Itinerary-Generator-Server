package com.example.myapp.controllers;

import java.util.ArrayList;
import java.util.List;
import com.example.myapp.models.TravelAgent;
import com.example.myapp.repositories.TravelAgentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class TravelAgentController {
    @Autowired
    TravelAgentRepository repository;

    List<TravelAgent> travelAgents = new ArrayList<TravelAgent>();

    @GetMapping("/api/travel_agents") 
    public List<TravelAgent> findAllTravelAgents() {
        return repository.findAllTravelAgents();
    }

}