package com.example.myapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.example.myapp.models.Itinerary;

public interface ItineraryRepository extends CrudRepository<Itinerary, Integer> {
    @Query("SELECT itinerary FROM Itinerary itinerary")
    public List<Itinerary> findAllItineraries();
}