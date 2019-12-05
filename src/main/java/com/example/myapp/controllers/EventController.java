package com.example.myapp.controllers;

import java.util.ArrayList;
import java.util.List;
import com.example.myapp.models.Event;
import com.example.myapp.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

}