package com.example.tripEase.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**********************************************
 Developer Name: Vikas
 Created on: 05-07-2026 03:29
 Project Name: tripEase
 /**********************************************/
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "driver_information")
@Builder
public class Driver
{
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cab_id")
    Cab cab;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;

    private String name;

    private int age;

    @Column(unique = true, nullable = false)
    private String emailId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private List<Booking> bookings = new ArrayList<>();
}
