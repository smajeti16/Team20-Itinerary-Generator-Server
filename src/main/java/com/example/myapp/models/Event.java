package com.example.myapp.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "Event_Itin_Map",
        joinColumns = {@JoinColumn(name = "event_id")},
        inverseJoinColumns = {@JoinColumn(name = "itinerary_id")}
    ) 
    private Set<Itinerary> itineraries = new HashSet<>();

    private String title;
    private String pictureURL;
    private String description;
    private float rating;

    // constructor 
}