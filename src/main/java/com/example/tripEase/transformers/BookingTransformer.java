package com.example.tripEase.transformers;

import com.example.tripEase.Enum.TripStatus;
import com.example.tripEase.dtos.request.BookingRequest;
import com.example.tripEase.dtos.response.BookingResponse;
import com.example.tripEase.model.Booking;
import com.example.tripEase.model.Cab;
import com.example.tripEase.model.Customer;
import com.example.tripEase.model.Driver;

/**********************************************
 Developer Name: Vikas
 Created on: 14-07-2026 01:32
 Project Name: tripEase ${
 /**********************************************/
public class BookingTransformer
{

    public static Booking bookingRequestToBooking(BookingRequest bookingRequest, double perKmRate)
    {
        return Booking.builder()
                .pickup(bookingRequest.getPickup())
                .destination(bookingRequest.getDestination())
                .tripDistanceInKm(bookingRequest.getTripDistanceInKm())
                .tripStatus(TripStatus.IN_Process)
                .billAmount(bookingRequest.getTripDistanceInKm() * perKmRate)
                .build();
    }


    public static BookingResponse bookingToBookingResponse(Booking booking, Customer savedCustomer, Driver driver, Cab cab)
    {
        return BookingResponse.builder()
                .bookedAt(booking.getBookedAt())
                .lastUpdateAt(booking.getLastUpdateAt())
                .bookingId(booking.getBookingId())
                .pickup(booking.getPickup())
                .destination(booking.getDestination())
                .tripDistanceInKm(booking.getTripDistanceInKm())
                .tripStatus(booking.getTripStatus())
                .billAmount(booking.getBillAmount())
                .customerResponse(CustomerTransformer.CustomerToCustomerResponse(savedCustomer))
                .cabResponse(CabTransformer.cabToCabResponse(cab, driver))
                .build();
    }
}
