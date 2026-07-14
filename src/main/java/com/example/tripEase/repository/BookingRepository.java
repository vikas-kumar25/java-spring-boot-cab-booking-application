package com.example.tripEase.repository;

import com.example.tripEase.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**********************************************
 Developer Name: Vikas
 Created on: 14-07-2026 01:25
 Project Name: tripEase ${
 /**********************************************/
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>
{

}
