package com.example.myapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.example.myapp.models.TravelAgent;

public interface TravelAgentRepository extends CrudRepository<TravelAgent, Integer> {
    @Query("SELECT travelagent FROM TravelAgent travelagent")
    public List<TravelAgent> findAllTravelAgents();
}