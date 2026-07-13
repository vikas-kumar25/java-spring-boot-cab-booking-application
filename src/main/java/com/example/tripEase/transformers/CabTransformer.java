package com.example.tripEase.transformers;

import com.example.tripEase.dtos.request.CabRequest;
import com.example.tripEase.dtos.response.CabResponse;
import com.example.tripEase.dtos.response.DriverResponse;
import com.example.tripEase.model.Cab;
import com.example.tripEase.model.Driver;

/**********************************************
 Developer Name: Vikas
 Created on: 13-07-2026 20:03
 Project Name: tripEase ${
 /**********************************************/
public class CabTransformer
{

    public static Cab cabRequestToCab(CabRequest cabRequest)
    {
        return Cab.builder()
                .cabModel(cabRequest.getCabModel())
                .cabNumber(cabRequest.getCabNumber())
                .perKmRate(cabRequest.getPerKmRate())
                .available(true)
                .build();

    }


    public static CabResponse cabToCabResponse(Cab cab, Driver savedDriver)
    {
        return CabResponse.builder()
                .cabNumber(cab.getCabNumber())
                .cabModel(cab.getCabModel())
                .available(cab.getAvailable())
                .perKmRate(cab.getPerKmRate())
                .driverR(DriverTransformer.driverToDriverResponse(savedDriver))
                .build();
    }
}
