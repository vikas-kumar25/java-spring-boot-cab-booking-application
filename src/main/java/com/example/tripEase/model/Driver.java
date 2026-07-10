package com.example.tripEase.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverId;

    private String name;

    private int age;

    @Column(name = "email_id")
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private List<Booking> bookings = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cab_id")
    Cab cab;
}
