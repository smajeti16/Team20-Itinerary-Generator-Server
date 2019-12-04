package com.example.myapp.models;

import java.util.List;

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
    private int userId;

    @ManyToOne
    private TravelAgent agent;

    private TravelAgent getAgent() {
        return agent;
    }

    // constructor
    public Request(int id, String location, int duration, int userId) {
        super();
        this.id = id;
        this.location = location;
        this.duration = duration;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}