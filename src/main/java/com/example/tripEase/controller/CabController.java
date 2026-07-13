package com.example.tripEase.controller;

import com.example.tripEase.dtos.request.CabRequest;
import com.example.tripEase.dtos.response.CabResponse;
import com.example.tripEase.model.Cab;
import com.example.tripEase.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**********************************************
 Developer Name: Vikas
 Created on: 13-07-2026 19:59
 Project Name: tripEase ${
 /**********************************************/
@RestController
@RequestMapping("/cab")
public class CabController
{

    @Autowired
    private CabService cabService;

    @PostMapping("/register/{driverId}")
    public CabResponse registerCab(@RequestBody CabRequest cabRequest, @PathVariable Long driverId)
    {
        return cabService.registerCab(cabRequest, driverId);
    }
}
