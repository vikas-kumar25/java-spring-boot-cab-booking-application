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
        Customer customer = new Customer();

        customer.setAge(customerRequest.getAge());
        customer.setName(customerRequest.getName());
        customer.setEmail(customerRequest.getEmail());
        customer.setGender(customerRequest.getGender());
        return customer;
    }

    //saved entity --Convert to--> ResponseDto
    public static CustomerResponse CustomerToCustomerResponse(Customer savedCustomer)
    {
        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setCustomerId(savedCustomer.getCustomerId());
        customerResponse.setName(savedCustomer.getName());
        customerResponse.setAge(savedCustomer.getAge());
        customerResponse.setEmail(savedCustomer.getEmail());
        customerResponse.setGender(savedCustomer.getGender());
        return customerResponse;
    }
}
