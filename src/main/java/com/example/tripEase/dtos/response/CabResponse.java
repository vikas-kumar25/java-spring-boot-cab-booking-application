package com.example.tripEase.dtos.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**********************************************
 Developer Name: Vikas
 Created on: 13-07-2026 20:03
 Project Name: tripEase ${
 /**********************************************/

@Getter
@Setter
@Builder
public class CabResponse
{
    private String cabNumber;

    private String cabModel;

    private double perKmRate;

    private boolean available;

    private DriverResponse driverR;
}
