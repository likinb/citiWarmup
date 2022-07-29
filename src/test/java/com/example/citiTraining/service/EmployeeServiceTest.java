package com.example.citiTraining.service;

import com.example.citiTraining.domain.Address;
import com.example.citiTraining.domain.Employee;
import com.example.citiTraining.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;
    @InjectMocks
    private EmployeeServiceImplementation service;

    //private List<Employee> employeeList = new ArrayList<>();

//    @BeforeEach
//    public void setup(){
//        Address address = new Address("Bangalore", "Karnataka");
//        Address address1 = new Address(null, "Karnataka");
//        Employee emp1 = new Employee("1", "Akash", 10000, address1);
//        Employee emp2 = new Employee("2", "Bharat", 10000, address);
//        Employee emp3 = new Employee("3", "Chandra", 10000, address);
//        employeeList.add(emp1);
//        employeeList.add(emp2);
//        employeeList.add(emp3);
//    }

    @DisplayName("Test for getEmployee service")
    @Test
    public void getEmployeeTest() {
        //given(repository.Data()).willReturn(employeeList);
        assertEquals("Chandra", service.getEmployee("3"));
    }

    @DisplayName("Test for getTotalSalary service")
    @Test
    public void getTotalSalaryTest() {
        //given(repository.Data()).willReturn(employeeList);
        assertEquals(110000, service.getTotalSalary());
    }

    @DisplayName("Test for getEmployees service")
    @Test
    public void getEmployeesTest() {
        //given(repository.Data()).willReturn(employeeList);
        List<String> expected = new ArrayList<>();
        expected.add("Akash");
        assertEquals(expected, service.getEmployees("Delhi"));
    }
}
