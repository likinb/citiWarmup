package com.example.citiTraining.repository;

import com.example.citiTraining.domain.Address;
import com.example.citiTraining.domain.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    public List<Employee> Data() {
        Address address = new Address("Bangalore", "Karnataka");
        Address address1 = new Address(null, "Karnataka");
        Employee emp1 = new Employee("1", "Akash", 20000, address1);
        Employee emp2 = new Employee("2", "Bharath", 40000, address);
        Employee emp3 = new Employee("3", "Chandra", 50000, address);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        return employeeList;
    }
}
