package com.example.myapp.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "itinerary")
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    // private List<Event> events;

    @ManyToMany(mappedBy = "itineraries", cascade = CascadeType.PERSIST)
    private Set<Event> eventMaps = new HashSet<>();
    // constructor 
    
}