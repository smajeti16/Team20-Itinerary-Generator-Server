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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.example.myapp.models.User;


@Entity
@Table(name = "itinerary")
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    private User getUser() {
        return this.user;
    }
    
    @ManyToMany(mappedBy = "itineraries", cascade = CascadeType.PERSIST)
    private Set<Event> eventMaps = new HashSet<>();

    // constructor 
    public Itinerary(int id, User user, Set<Event> maps) {
        super();
        this.id = id;
        this.user = user;
        this.eventMaps = maps;
    }
    
}