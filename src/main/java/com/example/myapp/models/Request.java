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
    private boolean pending;
    private boolean attractions;
    private boolean shopping;
    private boolean food;
    private boolean nightlife;

    @ManyToOne
    private TravelAgent agent;

    @ManyToOne
    private User user;

    private TravelAgent getAgent() {
        return agent;
    }

    public void setAgent(TravelAgent agent) {
        this.agent = agent;
    }

    public Request() {
        super();
    }

    // constructor
    public Request(int id, String location, int duration, boolean pending, boolean attractions, boolean shopping, boolean food, boolean nightlife) {
        super();
        this.id = id;
        this.location = location;
        this.duration = duration;
        this.pending = pending;
        this.setAttractions(attractions);
        this.setShopping(shopping);
        this.setFood(food);
        this.setNightlife(nightlife);
    }

     public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void set(Request request) {
        if (request.getLocation() != null) {
    		this.setLocation(request.getLocation());
    	}
    	if (request.getDuration() != 0) {
    		this.setDuration(request.getDuration());
        }
        if (request.getPending() == true || request.getPending() == false) {
            this.setPending(request.getPending());
        }
        if (request.getAttractions() == true || request.getAttractions() == false) {
            this.setAttractions(request.getAttractions());
        }
        if (request.getShopping() == true || request.getShopping() == false) {
            this.setShopping(request.getShopping());
        }
        if (request.getFood() == true || request.getFood() == false) {
            this.setFood(request.getFood());
        }
        if (request.getNightlife() == true || request.getNightlife() == false) {
            this.setNightlife(request.getNightlife());
        }
    }

    public void setPending(boolean newPending) {
        this.pending = newPending;
    }

    public boolean getPending() {
        return this.pending;
    }

    public boolean getNightlife() {
        return nightlife;
    }

    public void setNightlife(boolean nightlife) {
        this.nightlife = nightlife;
    }

    public boolean getFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean getShopping() {
        return shopping;
    }

    public void setShopping(boolean shopping) {
        this.shopping = shopping;
    }

    public boolean getAttractions() {
        return attractions;
    }

    public void setAttractions(boolean attractions) {
        this.attractions = attractions;
    }
}