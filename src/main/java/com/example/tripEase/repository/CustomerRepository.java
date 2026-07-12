package com.example.tripEase.repository;

import com.example.tripEase.Enum.Gender;
import com.example.tripEase.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.JpqlQueryBuilder;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**********************************************
 Developer Name: Vikas
 Created on: 06-07-2026 00:32
 Project Name: tripEase
 /**********************************************/
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
    List<Customer> findByGender(Gender gender);

    List<Customer> findByGenderAndAge(Gender gender, int age);

    //HQL Queries - Hibernate
    @Query("select c from Customer c where c.gender = :gender and c.age > :age")
    List<Customer> findByGenderAndAgeGreaterThan(
            @Param("gender") Gender gender,
            @Param("age") int age);

    //SQL Queries
//    @Query(value = "select * from customer_information where gender = :gender and age > :age", nativeQuery = true)
//    List<Customer> findByGenderAndAgeGreaterThan(
//            @Param("gender") String gender,
//            @Param("age") int age);
}
