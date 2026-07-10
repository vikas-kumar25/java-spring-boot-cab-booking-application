package com.example.tripEase.service;

import com.example.tripEase.dtos.request.CustomerRequest;
import com.example.tripEase.dtos.response.CustomerResponse;
import com.example.tripEase.exception.CustomerNotfoundException;
import com.example.tripEase.model.Customer;
import com.example.tripEase.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**********************************************
 Developer Name: Vikas
 Created on: 06-07-2026 00:32
 Project Name: tripEase
 /**********************************************/
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        //RequestDto --mapping to--> entity
        Customer customer = new Customer();

        customer.setAge(customerRequest.getAge());
        customer.setName(customerRequest.getName());
        customer.setEmail(customerRequest.getEmail());
        customer.setGender(customerRequest.getGender());

        customerRepository.save(customer);

        //entity --mapping to--> ResponseDto
        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setCustomerId(customer.getCustomerId());
        customerResponse.setName(customer.getName());
        customerResponse.setAge(customer.getAge());
        customerResponse.setEmail(customer.getEmail());
        customerResponse.setGender(customer.getGender());

        return customerResponse;
    }

    public CustomerResponse getStudent(Long id) {

        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if(optionalCustomer.isEmpty()) {
            throw new CustomerNotfoundException("Invalid Customer Id!");
        }

        Customer customer = optionalCustomer.get();
        //entity --mapping to--> ResponseDto
        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setCustomerId(customer.getCustomerId());
        customerResponse.setName(customer.getName());
        customerResponse.setAge(customer.getAge());
        customerResponse.setEmail(customer.getEmail());
        customerResponse.setGender(customer.getGender());

        return customerResponse;
    }
}
