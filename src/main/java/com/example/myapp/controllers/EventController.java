package com.example.myapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;

import com.example.myapp.models.Event;
import com.example.myapp.models.Itinerary;
import com.example.myapp.repositories.EventRepository;
import com.example.myapp.repositories.ItineraryRepository;

import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class EventController {
    @Autowired
    EventRepository repository;

    @Autowired
    ItineraryRepository itineraryRepository;

    List<Event> events = new ArrayList<Event>();

    @GetMapping("/api/events") 
    public List<Event> findAllEvents() {
        return repository.findAllEvents();
    }

    @GetMapping("/api/events/{eventId}")
    public Event findEventById(@PathVariable("eventId") Integer eventId) {
        Optional<Event> optional = repository.findById(eventId);
        return optional.get();
    }

    @DeleteMapping("/api/events/{eventId}")
    public List<Event> deleteEvent(@PathVariable("eventId") Integer eventId) {
        repository.deleteById(eventId);
        return this.findAllEvents();
    }

    @PostMapping("/api/events")
    public Event createEvent(@RequestBody Event event) {
        return repository.save(event);
    }

    @PutMapping("/api/events/{eventId}")
    public Event updateEvent(
        @PathVariable("eventId") Integer eventId, @RequestBody Event eventUpdates) {
        Optional<Event> optional = repository.findById(eventId);
        Event event = optional.get();
        event.set(eventUpdates);
        return repository.save(event);
    }

    @GetMapping("/api/add/event/{eventId}/itineraries/{itineraryId}")
    public Itinerary addEventToItinerary(@PathVariable("itineraryId") Integer itineraryId, 
                        @PathVariable("eventId") Integer eventId) {
        Event event = repository.findById(eventId).get();
        Itinerary itinerary = itineraryRepository.findById(itineraryId).get();
        itinerary.setEvent(event);
        itineraryRepository.save(itinerary); 
        return itinerary;
    }

}