package com.example.citiTraining;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
class CitiTrainingApplicationTests {

    private List<Employee> employeeList = new ArrayList<>();


    @BeforeEach
    public void setup(){
        Address address = new Address("Bangalore", "Karnataka");
        Address address1 = new Address(null, "Karnataka");
        Employee emp1 = new Employee(1, "Akash", 20000, address1);
        Employee emp2 = new Employee(2, "Bharath", 40000, address);
        Employee emp3 = new Employee(3, "Chandra", 50000, address);
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
    }

    @DisplayName("Test for Total salary calculation")
    @Test
    void totalSalaryTest() {
        TotalSalaryImplementation implementation = new TotalSalaryImplementation();
        int actual = implementation.TotalSalaryCalculation(employeeList);
        assertEquals(110000, actual);
    }

    @DisplayName("Test for Filtering employees on address")
    @Test
    void filterEmployeesTest() {
        FilterEmployees filterEmployees = new FilterEmployees();
        List<String> actual = new ArrayList<>();
        actual.add("Bharath");
        actual.add("Chandra");
        assertEquals(actual, filterEmployees.FilterCity(employeeList));
    }

    @DisplayName("Test for filter city functional interface")
    @Test
    void filterCityTest() {
        FilterEmployees filterEmployees = new FilterEmployees();
        assertEquals(true, filterEmployees.filterCity("Bangalore"));
    }

    @DisplayName("Test if city is provided as null")
    @Test
    void nullValueTest() {
        FilterEmployees filterEmployees = new FilterEmployees();
        assertEquals(false, filterEmployees.filterCity(null));
    }
}
