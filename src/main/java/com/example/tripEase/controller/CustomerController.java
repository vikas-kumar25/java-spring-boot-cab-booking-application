package com.example.tripEase.controller;

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
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/get-customer/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getStudent(id);
    }
}
