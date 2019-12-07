package com.example.myapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String location;
    private int duration;

    @ManyToOne
    private TravelAgent agent;

    @ManyToOne
    private User user;

    private TravelAgent getAgent() {
        return agent;
    }

    public Request() {
        super();
    }

    // constructor
    public Request(int id, String location, int duration) {
        super();
        this.id = id;
        this.location = location;
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}