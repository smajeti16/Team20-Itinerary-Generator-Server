package com.example.myapp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import com.example.myapp.models.Request;

public interface RequestRepository extends CrudRepository<Request, Integer> {
    @Query("SELECT request FROM Request request")
    public List<Request> findAllRequests();

    @Query("SELECT request FROM Request request WHERE request.pending=:pend")
    public List<Request> findPendingRequests(@PathVariable("pend") boolean pend);

    @Query("SELECT request FROM Request request WHERE request.user.id=:userId")
    public List<Request> findRequestsByUserId(@PathVariable("userId") Integer userId);
}