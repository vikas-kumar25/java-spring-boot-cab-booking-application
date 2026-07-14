package com.example.tripEase.repository;

import com.example.tripEase.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**********************************************
 Developer Name: Vikas
 Created on: 13-07-2026 20:00
 Project Name: tripEase ${
 /**********************************************/
@Repository
public interface CabRepository extends JpaRepository<Cab, Long>
{
    @Query("select c from Cab c where c.available = true order by rand()")
    Cab getAvailableCabRandomly();
}
