package com.example.tripEase.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**********************************************
 Developer Name: Vikas
 Created on: 05-07-2026 06:09
 Project Name: tripEase ${
 /**********************************************/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "cab_information")
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cabId;

    private String cabNumber;

    private String cabModel;

    private Double perKmRate;

    private Boolean available;
}
