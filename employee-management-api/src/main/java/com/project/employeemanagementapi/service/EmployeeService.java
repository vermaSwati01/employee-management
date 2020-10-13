package com.project.employeemanagementapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.project.employeemanagementapi.dao.EmployeeRepository;
import com.project.employeemanagementapi.exception.RecordNotFoundException;
import com.project.employeemanagementapi.model.EmployeeEntity;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;


	@PreAuthorize("hasRole('Employee') or hasRole('Admin')")
	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> employeeList = repository.findAll();

		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<EmployeeEntity>();
		}
	}

	@PreAuthorize("hasRole('Employee') or hasRole('Admin')")
	public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	@PreAuthorize("hasRole('Admin')")
	@Transactional
	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(entity.getId());

		if (employee.isPresent()) {
			EmployeeEntity newEntity = employee.get();
			newEntity.setEmail(entity.getEmail());
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setLastName(entity.getLastName());

			newEntity = repository.save(newEntity);

			return newEntity;
		} else {

			entity = repository.save(entity);

			return entity;
		}
	}

	@PreAuthorize("hasRole('Admin')")
	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	@PreAuthorize("hasRole('Admin')")
	@Transactional
	public EmployeeEntity UpdateEmployee(Long id, EmployeeEntity employee) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<EmployeeEntity> emp = repository.findById(id);

		if (emp.isPresent()) {
			EmployeeEntity newEmp = emp.get();
			newEmp.setEmail(employee.getEmail());
			newEmp.setFirstName(employee.getFirstName());
			newEmp.setLastName(employee.getLastName());
			// newEmp.setAccountNumber(employee.getAccountNumber());

			newEmp = repository.save(newEmp);

			return newEmp;
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

}