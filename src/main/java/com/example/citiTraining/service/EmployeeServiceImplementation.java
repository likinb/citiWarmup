package com.example.citiTraining.service;

import com.example.citiTraining.domain.Employee;
import com.example.citiTraining.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImplementation implements EmployeeService {


    @Override
    public String getEmployee(String employeeId) {
        EmployeeRepository repository = new EmployeeRepository();
        for (Employee employee : repository.Data()) {
            if(employee.employeeId.equalsIgnoreCase(employeeId)) {
                return employee.employeeName;
            }
        }
        return "Employee not found";
    }

    @Override
    public int getTotalSalary() {
        EmployeeRepository repository = new EmployeeRepository();
        TotalSalary totalSalary =
                (salary1, salary2) ->
                        salary1+salary2;

        Optional<List<Employee>> employees = Optional.ofNullable(repository.Data());
        if (employees.isPresent()) {
            List<Integer> salaries =
                    repository.Data().stream().map(x -> x.salary).collect(Collectors.toList());
            int sum = salaries.stream().reduce(0, (a, b) -> totalSalary.add(a, b));
            return sum;
        } else {
            System.out.println("List is empty");
            return 0;
        }
    }

    @Override
    public List<String> getEmployees(String city) {
        EmployeeRepository repository = new EmployeeRepository();
        Optional<String> pathVariable = Optional.of(city);
        List<String> result = new ArrayList<>();
        String defaultAddress ="Delhi";
    for (Employee employee : repository.Data()) {
        Optional<String> optAddress = Optional.of(Optional.ofNullable(employee.address.city).orElse(defaultAddress));
        if(pathVariable.equals(optAddress)) {
            result.add(employee.employeeName);
        }
    }
    return result;
    }
}
