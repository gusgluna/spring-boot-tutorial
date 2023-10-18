package com.gusgluna.springboottutorial.service;

import com.gusgluna.springboottutorial.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId);

    String deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);
}
