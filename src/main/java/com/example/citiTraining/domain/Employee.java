package com.example.citiTraining.domain;

import com.example.citiTraining.domain.Address;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Employee {

    public String employeeId;
    public String employeeName;
    public int salary;
    public Address address;
}
