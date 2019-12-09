package com.example.myapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import com.example.myapp.models.Itinerary;

public interface ItineraryRepository extends CrudRepository<Itinerary, Integer> {
    @Query("SELECT itinerary FROM Itinerary itinerary")
    public List<Itinerary> findAllItineraries();

    // @Query("SELECT event FROM Event event ")
    // public List<Event> getEventsByItineraryId(@Param("itineraryId") Integer itineraryId);
}

