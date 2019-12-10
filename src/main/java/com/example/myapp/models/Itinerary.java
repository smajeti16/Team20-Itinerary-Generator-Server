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

    private int itin_duration;

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
    public Itinerary(int id, int itin_duration) {
        super();
        this.id = id;
        this.itin_duration = itin_duration;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Event> getEvents() {
        return this.eventMaps;
    }
     
    // add the new event to the eventMaps HashSet
    public void setEvent(Event event) {
        eventMaps.add(event);
    }

    public void setItinDuration(int newDuration) {
        this.itin_duration = newDuration;
    }

    public int getItinDuration() {
        return this.itin_duration;
    }
    
}