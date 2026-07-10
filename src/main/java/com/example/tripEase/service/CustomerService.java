package com.example.tripEase.service;

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

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getStudent(Long id) {

        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if(optionalCustomer.isEmpty()) {
            throw new CustomerNotfoundException("Invalid Customer Id!");
        }
        return optionalCustomer.get();
    }
}
