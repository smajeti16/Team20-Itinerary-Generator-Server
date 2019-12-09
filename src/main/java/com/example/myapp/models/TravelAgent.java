package com.example.myapp.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.example.myapp.models.Request;

@Entity
@Table(name = "travel_agent")
public class TravelAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "agent")
    private List<Request> requests;

    

    public TravelAgent() {
        super();
    }

    // constructor 
    public TravelAgent(int id, List<Request> requests) {
        super();
        this.id = id;
        this.requests = requests;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Request> getRequests() {
        return this.requests;
    }
     
    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

}