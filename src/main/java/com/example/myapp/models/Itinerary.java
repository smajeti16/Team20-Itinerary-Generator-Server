package com.example.myapp.models;

import java.util.HashSet;
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

    @ManyToMany(mappedBy = "itins", cascade = CascadeType.PERSIST)
    private Set<User> userMaps = new HashSet<>();

    @ManyToMany(mappedBy = "event_itins", cascade = CascadeType.PERSIST)
    private Set<Event> eventMaps = new HashSet<>();

    @ManyToOne
    private User userFaves;

    public Itinerary() {
        super();
    }

    // constructor 
    public Itinerary(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // public void set(Event eventUpdate, User userFave) {
    //     if(eventUpdate.getDescription() != null) {
    //         // this.eventMaps.
    //     }
    // }
    
}