package com.example.tripEase.model;

import com.example.tripEase.Enum.TripStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

/**********************************************
 Developer Name: Vikas
 Created on: 05-07-2026 06:02
 Project Name: tripEase ${
 /**********************************************/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "booking_information")
public class Booking
{
    @CreationTimestamp
    Date bookedAt;

    @UpdateTimestamp
    Date lastUpdateAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    private String pickup;

    private String destination;

    private int tripDistanceInKm;

    private TripStatus tripStatus;

    private Double billAmount;

}
