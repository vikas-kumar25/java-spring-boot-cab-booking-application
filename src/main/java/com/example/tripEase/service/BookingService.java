package com.example.tripEase.service;

import com.example.tripEase.dtos.request.BookingRequest;
import com.example.tripEase.dtos.response.BookingResponse;
import com.example.tripEase.exception.CustomerNotFoundException;
import com.example.tripEase.model.Booking;
import com.example.tripEase.model.Customer;
import com.example.tripEase.repository.CustomerRepository;
import com.example.tripEase.transformers.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**********************************************
 Developer Name: Vikas
 Created on: 14-07-2026 01:25
 Project Name: tripEase
 /**********************************************/
@Service
public class BookingService
{
    @Autowired
    private CustomerRepository customerRepository;

    public BookingResponse bookCab(BookingRequest bookingRequest, Long customerId)
    {
        return  null;
    }
}
