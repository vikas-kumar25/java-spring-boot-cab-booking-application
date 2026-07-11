package com.example.tripEase.service;

import com.example.tripEase.Enum.Gender;
import com.example.tripEase.dtos.request.CustomerRequest;
import com.example.tripEase.dtos.response.CustomerResponse;
import com.example.tripEase.exception.CustomerNotFoundException;
import com.example.tripEase.model.Customer;
import com.example.tripEase.repository.CustomerRepository;
import com.example.tripEase.transformers.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**********************************************
 Developer Name: Vikas
 Created on: 06-07-2026 00:32
 Project Name: tripEase
 /**********************************************/

@Service
public class CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest)
    {
        //RequestDto --convert to--> entity
        Customer customer = CustomerTransformer.CustomerRequestToCustomer(customerRequest);

        //save the entity to DB
        Customer savedCustomer = customerRepository.save(customer);

        //saved entity --Convert to--> ResponseDto
        CustomerResponse customerResponse = CustomerTransformer.CustomerToCustomerResponse(savedCustomer);

        return customerResponse;
    }

    public CustomerResponse getStudent(Long id)
    {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isEmpty())
        {
            throw new CustomerNotFoundException("Invalid Customer Id!");
        }

        Customer savedCustomer = optionalCustomer.get();

        //savedEntity --mapping to--> ResponseDto
        CustomerResponse customerResponse = CustomerTransformer.CustomerToCustomerResponse(savedCustomer);

        return customerResponse;
    }

    public List<CustomerResponse> getAllByGender(Gender gender)
    {
        List<Customer> savedCustomer = customerRepository.findByGender(gender);

        List<CustomerResponse> customerResponse = new ArrayList<>();

        for (Customer customer : savedCustomer)
        {
            customerResponse.add(CustomerTransformer.CustomerToCustomerResponse(customer));
        }
        return customerResponse;
    }

    public List<CustomerResponse> getAllByGenderAndAge(Gender gender, int age)
    {
        List<Customer> savedCustomers = customerRepository.findByGenderAndAge(gender, age);

        List<CustomerResponse> responseCustomers = new ArrayList<>();

        for (Customer customer : savedCustomers)
        {
            responseCustomers.add(CustomerTransformer.CustomerToCustomerResponse(customer));
        }
        return responseCustomers;
    }
}
