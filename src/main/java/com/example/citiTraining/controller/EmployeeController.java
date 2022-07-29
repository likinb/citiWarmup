package com.example.citiTraining.controller;

import com.example.citiTraining.domain.Employee;
import com.example.citiTraining.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/employees")
@RestController
public class EmployeeController {

    private EmployeeService service;

    @GetMapping("/{employeeId}")
    public ResponseEntity<String> getEmployee(@PathVariable("employeeId") String employeeId) {
        return new ResponseEntity<>(service.getEmployee(employeeId), HttpStatus.OK);
    }

    @GetMapping("/totalSalary")
    public ResponseEntity<Integer> getTotalSalary() {
        return new ResponseEntity<>(service.getTotalSalary(), HttpStatus.OK);
    }

    @GetMapping("/address/{city}")
    public ResponseEntity<List<String>> getEmployees(@PathVariable("city") String city) {
        return new ResponseEntity<>(service.getEmployees(city), HttpStatus.OK);
    }
}
