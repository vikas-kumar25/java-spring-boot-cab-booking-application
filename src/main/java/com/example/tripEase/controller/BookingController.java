package com.example.tripEase.controller;

import com.example.tripEase.dtos.request.BookingRequest;
import com.example.tripEase.dtos.response.BookingResponse;
import com.example.tripEase.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**********************************************
 Developer Name: Vikas
 Created on: 14-07-2026 01:24
 Project Name: tripEase ${
 /**********************************************/
@RestController
@RequestMapping("/booking")
public class BookingController
{
    @Autowired
    private BookingService bookingService;

    @PostMapping("/book/customerId")
    public BookingResponse bookCab(@RequestBody BookingRequest bookingRequest, @PathVariable("customerId") Long customerId)
    {
        return bookingService.bookCab(bookingRequest, customerId);
    }
}
