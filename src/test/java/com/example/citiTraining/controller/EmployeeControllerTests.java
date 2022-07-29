package com.example.citiTraining.controller;

import com.example.citiTraining.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeService service;

    @DisplayName("Test for getEmployee")
    @Test
    public void getEmployeeTest() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders
                        .get("/employees/1")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @DisplayName("Test for getTotalSalary")
    @Test
    public void getTotalSalaryTest() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders
                        .get("/employees/totalSalary")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @DisplayName("Test for getEmployees")
    @Test
    public void getEmployeesTest() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders
                        .get("/employees/address/Bangalore")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }
}
