package com.example.tripEase.controller;

import com.example.tripEase.dtos.request.CustomerRequest;
import com.example.tripEase.dtos.response.CustomerResponse;
import com.example.tripEase.model.Customer;
import com.example.tripEase.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**********************************************
 Developer Name: Vikas
 Created on: 06-07-2026 00:28
 Project Name: tripEase ${
 /**********************************************/
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest) {
        return customerService.addCustomer(customerRequest);
    }

    @GetMapping("/get-customer/{id}")
    public CustomerResponse getCustomer(@PathVariable Long id) {
        return customerService.getStudent(id);
    }
}
