package com.example.myapp.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.myapp.models.Itinerary;
import com.example.myapp.repositories.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

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

    @GetMapping("/api/itineraries/{itineraryId}")
    public Itinerary findItineraryById(@PathVariable("itineraryId") Integer itineraryId) {
        Optional<Itinerary> optional = repository.findById(itineraryId);
        return optional.get();
    }

    @DeleteMapping("/api/itineraries/{itineraryId}")
    public List<Itinerary> deleteItinerary(@PathVariable("itineraryId") Integer itineraryId) {
        repository.deleteById(itineraryId);
        return this.findAllItineraries();
    }

    @PostMapping("/api/itineraries")
    public List<Itinerary> createItinerary(@RequestBody Itinerary itinerary) {
        repository.save(itinerary);
        return this.findAllItineraries();
    }

    @PutMapping("/api/itineraries/{itineraryId}")
    public List<Itinerary> updateItinerary(
        @PathVariable("itineraryId") Integer itineraryId, 
        @RequestBody Itinerary itineraryUpdates) {
        Optional<Itinerary> optional = repository.findById(itineraryId);
        Itinerary itinerary = optional.get();
        repository.save(itinerary);
        return this.findAllItineraries();
    }

}