package com.example.tripEase.service;

import com.example.tripEase.dtos.request.BookingRequest;
import com.example.tripEase.dtos.response.BookingResponse;
import com.example.tripEase.exception.CabNotAvailableException;
import com.example.tripEase.exception.CustomerNotFoundException;
import com.example.tripEase.model.Booking;
import com.example.tripEase.model.Cab;
import com.example.tripEase.model.Customer;
import com.example.tripEase.model.Driver;
import com.example.tripEase.repository.BookingRepository;
import com.example.tripEase.repository.CabRepository;
import com.example.tripEase.repository.CustomerRepository;
import com.example.tripEase.repository.DriverRepository;
import com.example.tripEase.transformers.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

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

    @Autowired
    private CabRepository cabRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    JavaMailSender javaMailSender;

    public BookingResponse bookCab(BookingRequest bookingRequest, Long customerId)
    {
        //find customer by customerId------
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isEmpty())
        {
            throw new CustomerNotFoundException("Customer is not registered!");
        }
        Customer customer = optionalCustomer.get(); //Extracted existing customer

        //Check for cab availability from cabRepository------
        Cab availableCab = cabRepository.getAvailableCabRandomly();
        if (availableCab == null)
        {
            throw new CabNotAvailableException("Sorry! Currently no cab is available");
        }

        //Create Booking------
        //BookingRequest to Booking entity
        Booking booking = BookingTransformer.bookingRequestToBooking(bookingRequest, availableCab.getPerKmRate());  //here booking id is null
        Booking savedBooking = bookingRepository.save(booking);     //now booking has a id(PK) after saving in db

        availableCab.setAvailable(false);   //set false, this available is booked now
        customer.getBookings().add(booking);    //customer got its booking

        //found driver from cab_id
        Driver driver = driverRepository.getDriverByCabId(availableCab.getCabId());
        driver.getBookings().add(booking);  //driver got its booking

        //if we don't save booking before then here while saving booking in db, we get 2 different booking id for same booking
        Customer savedCustomer = customerRepository.save(customer);
        Driver savedDrier = driverRepository.save(driver);

        //sending cab booked mail to customer
        sendEmail(savedCustomer, availableCab);

        //Booking to bookingResponse
        return BookingTransformer.bookingToBookingResponse(savedBooking, savedCustomer, savedDrier, availableCab);
    }

    private void sendEmail(Customer savedCustomer, Cab availableCab)
    {
        SimpleMailMessage message = new SimpleMailMessage();

        String text = "Congratulations!! "+savedCustomer.getName()+". Your Cab has been booked."
                +"\n Cab Number is: "+ availableCab.getCabNumber()+ "\n Cab Model: "+availableCab.getCabModel();

        message.setFrom("25vk04@gmail.com");
        message.setTo(savedCustomer.getEmailId());
        message.setSubject("Cab Booked");
        message.setText(text);

        // This line pushes the email to the SMTP server
        javaMailSender.send(message);
    }
}
