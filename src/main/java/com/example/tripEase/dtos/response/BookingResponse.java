package com.example.tripEase.dtos.response;

import com.example.tripEase.Enum.TripStatus;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

/**********************************************
 Developer Name: Vikas
 Created on: 14-07-2026 01:29
 Project Name: tripEase ${
 /**********************************************/
@Getter
@Setter
public class BookingResponse
{

    Date bookedAt;

    Date lastUpdateAt;

    private Long bookingId;

    private String pickup;

    private String destination;

    private int tripDistanceInKm;

    private TripStatus tripStatus;

    private Double billAmount;

    private CustomerResponse customerResponse;

    private CabResponse cabResponse;

}
