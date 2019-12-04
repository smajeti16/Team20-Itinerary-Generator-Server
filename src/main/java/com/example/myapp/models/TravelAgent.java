package com.example.myapp.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "travel_agent")
public class TravelAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // private List<Integer> userIds;
    // private List<Integer> requestIds;

    // constructor 
}