package com.example.myapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import com.example.myapp.models.Event;
import com.example.myapp.models.Itinerary;

public interface ItineraryRepository extends CrudRepository<Itinerary, Integer> {
    @Query("SELECT itinerary FROM Itinerary itinerary")
    public List<Itinerary> findAllItineraries();

    @Query("SELECT event FROM Event event ")
    public List<Event> getEventsByItineraryId(@Param("itineraryId") Integer itineraryId);

    // @Query("select u.userName from User u inner join u.area ar where ar.idArea = :idArea")
}

// List<Object[]> authors = em.createQuery("SELECT a, b FROM Author a LEFT" + 
//  "JOIN a.books b WHERE a.lastName = 'Janssen'").getResultList();



// SELECT event, i FROM Event event JOIN e.id i WHERE i.itinerary_id=:itineraryId