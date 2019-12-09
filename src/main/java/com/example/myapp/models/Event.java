package com.example.myapp.models;

import java.util.HashSet;
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
    private Set<Itinerary> event_itins = new HashSet<>();

    private String title;
    private String pictureURL;
    private String description;
    private float rating;
    private Integer day;

    // constructors 
    public Event() {
        super();
    }

    public Event(int id, String title, String pictureURL, String description, float rating, Integer day) {
        super();
        this.id = id;
        this.setTitle(title);
        this.setPictureURL(pictureURL);
        this.setDescription(description);
        this.setRating(rating);
        this.setDay(day);
    }

     public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void set(Event event) {
    	if (event.getDescription() != null) {
    		this.setDescription(event.getDescription());
    	}
    	if (event.getPictureURL() != null) {
    		this.setPictureURL(event.getPictureURL());
    	}
    	if (event.getRating() != 0) {
            this.setRating(event.getRating());

    	}
    	if (event.getDay() != 0) {
            this.setDay(event.getDay());
    	}
    	if (event.getTitle() != null) {
            this.setTitle(event.getTitle());
    	}
    }
    
}