package com.example.tripEase.dtos.response;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**********************************************
 Developer Name: Vikas
 Created on: 12-07-2026 16:29
 Project Name: tripEase ${
 /**********************************************/
@Getter
@Setter
@Builder
public class DriverResponse
{
    private Long driverId;

    private String name;

    private int age;

    private String email;

}
