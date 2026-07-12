package com.example.tripEase.transformers;

import com.example.tripEase.dtos.request.DriverRequest;
import com.example.tripEase.dtos.response.DriverResponse;
import com.example.tripEase.model.Driver;

/**********************************************
 Developer Name: Vikas
 Created on: 12-07-2026 16:38
 Project Name: tripEase ${
 /**********************************************/
public class DriverTransformer
{
    public static Driver driverRequestToDriver(DriverRequest driverRequest)
    {
        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .email(driverRequest.getEmail())
                .build();
    }

    public static DriverResponse driverToDriverResponse(Driver savedDriver)
    {
        return DriverResponse.builder()
                .driverId(savedDriver.getDriverId())
                .name(savedDriver.getName())
                .age(savedDriver.getAge())
                .email(savedDriver.getEmail())
                .build();
    }
}
