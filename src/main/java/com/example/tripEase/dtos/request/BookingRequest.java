package com.example.tripEase.dtos.request;

import lombok.Getter;
import lombok.Setter;

/**********************************************
 Developer Name: Vikas
 Created on: 14-07-2026 01:28
 Project Name: tripEase ${
 /**********************************************/
@Getter
@Setter
public class BookingRequest
{
    private String pickup;

    private String destination;

    private int tripDistanceInKm;

}
