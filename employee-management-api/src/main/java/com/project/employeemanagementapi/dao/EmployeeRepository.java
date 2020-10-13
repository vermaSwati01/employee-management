package com.project.employeemanagementapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.employeemanagementapi.model.EmployeeEntity;
 
@Repository
public interface EmployeeRepository
        extends JpaRepository<EmployeeEntity, Long> {
 
}
