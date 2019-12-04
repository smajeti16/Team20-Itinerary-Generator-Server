package com.example.myapp.models;

import java.util.List;
import com.example.myapp.models.Request;
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
    private List<Itinerary> itineraries;

    // User constructor
    public User(int id, String firstName, String lastName, String username, String password, String email) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    
}