package com.example.citiTraining;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TotalSalaryImplementation {
    public int TotalSalaryCalculation(List<Employee> employeeList) {
        TotalSalary totalSalary =
                (salary1, salary2) ->
                        salary1+salary2;

        Optional<List<Employee>> employees = Optional.ofNullable(employeeList);
    if (employees.isPresent()) {
      List<Integer> salaries =
          employeeList.stream().map(x -> x.salary).collect(Collectors.toList());
      int sum = salaries.stream().reduce(0, (a, b) -> totalSalary.add(a, b));
      return sum;
      } else {
            System.out.println("List is empty");
            return 0;
        }
    }
}
