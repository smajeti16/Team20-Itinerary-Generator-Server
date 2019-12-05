package com.example.myapp.controllers;

import java.util.ArrayList;
import java.util.List;
import com.example.myapp.models.Itinerary;
import com.example.myapp.repositories.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ItineraryController {
    @Autowired
    ItineraryRepository repository;

    List<Itinerary> itineraries = new ArrayList<Itinerary>();

    @GetMapping("/api/itineraries") 
    public List<Itinerary> findAllItineraries() {
        return repository.findAllItineraries();
    }

}