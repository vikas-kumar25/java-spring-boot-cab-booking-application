package com.example.tripEase.dtos.request;

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
public class CustomerRequest {

    private String name;

    private int age;

    private String email;

    private Gender gender;
}
