package com.example.myapp.controllers;

import java.util.ArrayList;
import java.util.List;
import com.example.myapp.models.Event;
import com.example.myapp.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class EventController {
    @Autowired
    EventRepository repository;

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
    public List<Event> createEvent(@RequestBody Event event) {
        repository.save(event);
        return this.findAllEvents();
    }

    @PutMapping("/api/events/{eventId}")
    public List<Event> updateEvent(
        @PathVariable("eventId") Integer eventId, 
        @RequestBody Event eventUpdates) {
        Optional<Event> optional = repository.findById(eventId);
        Event event = optional.get();
        repository.save(event);
        return this.findAllEvents();
    }

}