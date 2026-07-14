package com.example.tripEase.controller;

import com.example.tripEase.dtos.request.DriverRequest;
import com.example.tripEase.dtos.response.DriverResponse;
import com.example.tripEase.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**********************************************
 Developer Name: Vikas
 Created on: 12-07-2026 16:25
 Project Name: tripEase ${
 /**********************************************/

@RestController
@RequestMapping("/driver")
public class DriverController
{
    @Autowired
    private DriverService driverService;

    @PostMapping("/add")
    public DriverResponse addDriver(@RequestBody DriverRequest driverRequest)
    {
        return driverService.addDriver(driverRequest);
    }

    @GetMapping("/get-driver/{driverId}")
    public DriverResponse getDriver(@PathVariable Long driverId)
    {
        return driverService.getDriver(driverId);
    }

    @GetMapping("/get-all")
    public List<DriverResponse> getAllDrivers()
    {
        return driverService.getAllDrivers();
    }

}
