package com.gusgluna.springboottutorial.repository;

import com.gusgluna.springboottutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
