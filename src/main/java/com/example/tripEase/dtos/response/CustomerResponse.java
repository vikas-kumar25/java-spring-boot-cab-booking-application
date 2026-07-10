package com.example.tripEase.dtos.response;

import com.example.tripEase.Enum.Gender;
import lombok.Getter;
import lombok.Setter;

/**********************************************
 Developer Name: Vikas
 Created on: 10-07-2026 20:29
 Project Name: tripEase ${
 /**********************************************/

@Getter
@Setter

public class CustomerResponse
{
    private Long customerId;

    private String name;

    private int age;

    private String email;

    private Gender gender;
}
