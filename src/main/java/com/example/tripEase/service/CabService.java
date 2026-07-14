package com.example.tripEase.service;

import com.example.tripEase.dtos.request.CabRequest;
import com.example.tripEase.dtos.response.CabResponse;
import com.example.tripEase.exception.DriverNotFoundException;
import com.example.tripEase.model.Cab;
import com.example.tripEase.model.Driver;
import com.example.tripEase.repository.DriverRepository;
import com.example.tripEase.transformers.CabTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**********************************************
 Developer Name: Vikas
 Created on: 13-07-2026 19:59
 Project Name: tripEase ${
 /**********************************************/
@Service
public class CabService
{

    @Autowired
    private DriverRepository driverRepository;

    public CabResponse registerCab(CabRequest cabRequest, Long driverId)
    {
        //Check driver exist or not
        Optional<Driver> optionalDriver = driverRepository.findById(driverId);

        if (optionalDriver.isEmpty())
        {
            throw new DriverNotFoundException("Driver Not Found!");
        }
        //Extract driver
        Driver driver = optionalDriver.get();

        //cabRequestDto --> cab entity
        Cab cab = CabTransformer.cabRequestToCab(cabRequest);

        //Diver have complete cab reference now (so, if we save driver then hibernate will save cab also)
        driver.setCab(cab);

        //Cascading done
        Driver savedDriver = driverRepository.save(driver);

        // Links cab with driver to verify registration mapping.
        CabResponse cabResponse = CabTransformer.cabToCabResponse(savedDriver.getCab(), savedDriver);

        return cabResponse;
    }

}
