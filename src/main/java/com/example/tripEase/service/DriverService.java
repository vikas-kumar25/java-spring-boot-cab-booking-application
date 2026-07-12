package com.example.tripEase.service;

import com.example.tripEase.dtos.request.DriverRequest;
import com.example.tripEase.dtos.response.DriverResponse;
import com.example.tripEase.exception.CustomerNotFoundException;
import com.example.tripEase.exception.DriverNotFoundException;
import com.example.tripEase.model.Driver;
import com.example.tripEase.repository.DriverRepository;
import com.example.tripEase.transformers.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.tripEase.transformers.DriverTransformer.driverToDriverResponse;

/**********************************************
 Developer Name: Vikas
 Created on: 12-07-2026 16:26
 Project Name: tripEase ${
 /**********************************************/
@Service
public class DriverService
{
    @Autowired
    DriverRepository driverRepository;

    public DriverResponse addDriver(DriverRequest driverRequest)
    {
        //DriverRequest --> Entity
        Driver savedDriver = driverRepository.save(DriverTransformer.driverRequestToDriver(driverRequest));

        //Entity  --> DriverResponse
        return driverToDriverResponse(savedDriver);
    }


    //get particular driver by id
    public DriverResponse getDriver(Long driverId)
    {
        Optional<Driver> foundDriver = driverRepository.findById(driverId);

        if (foundDriver.isEmpty())
        {
            throw new CustomerNotFoundException("Invalid Driver Id!");
        }
        //save found driver
        Driver driver = foundDriver.get();

        //Driver entity --> DriverResponse
        DriverResponse driverResponse = driverToDriverResponse(driver);

        return driverResponse;
    }

    //get all driver
    public List<DriverResponse> getAllDrivers()
    {
        List<Driver> allDriver = driverRepository.findAll();

        //driver entity ---> Driver Response
        List<DriverResponse> driverResponses = new ArrayList<>();
        for (Driver driver : allDriver)
        {
            driverResponses.add(DriverTransformer.driverToDriverResponse(driver));
        }
        return driverResponses;
    }
}
