package com.example.myapp.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Request> requests;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "User_Itin_Map",
        joinColumns = {@JoinColumn(name = "user_id")},
        inverseJoinColumns = {@JoinColumn(name = "itinerary_id")}
    ) 
    private Set<Itinerary> itins = new HashSet<>();

    private Set<Itinerary> getItineraries() {
        return this.itins;
    }

    public User() {
        super();
    }

    // User constructor
    public User(int id, String firstName, String lastName, String username, String password, String email) {
        super();
        this.id = id;
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
}