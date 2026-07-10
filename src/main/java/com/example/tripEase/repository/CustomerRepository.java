package com.example.tripEase.repository;

import com.example.tripEase.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**********************************************
 Developer Name: Vikas
 Created on: 06-07-2026 00:32
 Project Name: tripEase
 /**********************************************/
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{

}
