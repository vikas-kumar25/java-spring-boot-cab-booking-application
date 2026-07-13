package com.example.tripEase.model;

import jakarta.persistence.*;
import lombok.*;

/**********************************************
 Developer Name: Vikas
 Created on: 05-07-2026 06:09
 Project Name: tripEase ${
 /**********************************************/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Builder
@Entity
@Table(name = "cab_information")
public class Cab
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cabId;

    @Column(unique = true, nullable = false)
    private String cabNumber;

    private String cabModel;

    private Double perKmRate;

    private Boolean available;
}
