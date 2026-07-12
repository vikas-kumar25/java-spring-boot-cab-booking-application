package com.example.tripEase.transformers;

import com.example.tripEase.dtos.request.CustomerRequest;
import com.example.tripEase.dtos.response.CustomerResponse;
import com.example.tripEase.model.Customer;

/**********************************************
 Developer Name: Vikas
 Created on: 11-07-2026 03:18
 Project Name: tripEase ${
 /**********************************************/
public class CustomerTransformer
{
    //RequestDto --convert to--> entity
    public static Customer CustomerRequestToCustomer(CustomerRequest customerRequest)
    {
        Customer customer = Customer.builder()
                .age(customerRequest.getAge())
                .name(customerRequest.getName())
                .emailId(customerRequest.getEmailId())
                .gender(customerRequest.getGender())
                .build();

        return customer;
    }

    //saved entity --Convert to--> ResponseDto
    public static CustomerResponse CustomerToCustomerResponse(Customer savedCustomer)
    {
        return CustomerResponse.builder()
                .customerId(savedCustomer.getCustomerId())
                .name(savedCustomer.getName())
                .age(savedCustomer.getAge())
                .emailId(savedCustomer.getEmailId())
                .gender(savedCustomer.getGender())
                .build();
    }
}
