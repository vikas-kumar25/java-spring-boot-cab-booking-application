package com.example.tripEase.repository;

import com.example.tripEase.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**********************************************
 Developer Name: Vikas
 Created on: 12-07-2026 16:27
 Project Name: tripEase ${
 /**********************************************/
public interface DriverRepository extends JpaRepository<Driver, Long>
{
    @Query(value = "select * from driver_information where cab_id = :cabId", nativeQuery = true)
    Driver getDriverByCabId(@Param("cabId") Long cabId);
}
