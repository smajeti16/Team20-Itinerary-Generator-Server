package com.example.myapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.example.myapp.models.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {
    @Query("SELECT event FROM Event event")
    public List<Event> findAllEvents();
}