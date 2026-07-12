package com.example.tripEase.model;

import com.example.tripEase.Enum.Gender;
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
@Getter
@Setter

@Entity
@Table(name = "customer_information")
@Builder
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;

    private int age;

    @Column(unique = true, nullable = false)
    private String emailId;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    //uni-Directional Relationship
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")  //Creating Fk & Joining table
    private List<Booking> bookings = new ArrayList<>();
}
