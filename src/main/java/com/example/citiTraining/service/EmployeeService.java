package com.example.citiTraining.service;

import com.example.citiTraining.domain.Employee;

import java.util.List;

public interface EmployeeService {

    String getEmployee(String employeeId);

    int getTotalSalary();

    List<String> getEmployees(String city);
}
