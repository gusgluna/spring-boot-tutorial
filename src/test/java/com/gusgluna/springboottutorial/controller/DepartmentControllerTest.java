package com.gusgluna.springboottutorial.controller;

import com.gusgluna.springboottutorial.entity.Department;
import com.gusgluna.springboottutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentId(1L)
                .departmentName("IT")
                .departmentAddress("Ahmedabad")
                .departmentCode("IT-06")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
     Department    inputDepartment = Department.builder()
                .departmentName("IT")
                .departmentAddress("Ahmedabad")
                .departmentCode("IT-06")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                "\t\"departmentName\":\"IT\",\n" +
                "\t\"departmentAddress\":\"Ahmedabad\",\n" +
                "\t\"departmentCode\":\"IT-06\"\n" +
                "}"
                )).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}