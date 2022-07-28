package com.example.citiTraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


//@SpringBootApplication
public class CitiTrainingApplication {


	public static void main(String[] args) {
		//SpringApplication.run(CitiTrainingApplication.class, args);
		Address address = new Address("Bangalore", "Karnataka");
		Address address1 = new Address(null, "Karnataka");
		Employee emp1 = new Employee(1, "Akash", 20000, address1);
		Employee emp2 = new Employee(2, "Bharath", 40000, address);
		Employee emp3 = new Employee(3, "Chandra", 50000, address);
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);

		TotalSalaryImplementation implementation = new TotalSalaryImplementation();
		FilterEmployees employees = new FilterEmployees();
		System.out.println("*******************************************");
    	System.out.println("Total salary = "+implementation.TotalSalaryCalculation(employeeList));
		System.out.println("*******************************************");
    	System.out.println("Employees who reside in Bangalore - ");
    	System.out.println(employees.FilterCity(employeeList));
		System.out.println("*******************************************");
	}
}
