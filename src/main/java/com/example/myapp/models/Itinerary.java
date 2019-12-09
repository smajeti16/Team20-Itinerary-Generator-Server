package com.example.myapp.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.example.myapp.models.User;


@Entity
@Table(name = "itinerary")
public class Itinerary {
    @Id
    private int id;

    @ManyToMany(mappedBy = "itins", cascade = CascadeType.PERSIST)
    private Set<User> userMaps = new HashSet<>();

    @ManyToMany(mappedBy = "event_itins", cascade = CascadeType.PERSIST)
    private Set<Event> eventMaps = new HashSet<>();

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
    
}