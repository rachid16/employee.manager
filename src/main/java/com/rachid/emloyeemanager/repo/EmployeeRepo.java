package com.rachid.emloyeemanager.repo;

import com.rachid.emloyeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
