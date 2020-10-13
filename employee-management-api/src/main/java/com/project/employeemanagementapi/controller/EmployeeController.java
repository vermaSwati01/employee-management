package com.project.employeemanagementapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.employeemanagementapi.exception.RecordNotFoundException;
import com.project.employeemanagementapi.model.EmployeeEntity;
import com.project.employeemanagementapi.service.EmployeeService;

 
@RestController
@RequestMapping("/api/employees")
@Validated
public class EmployeeController
{
    @Autowired
    EmployeeService service;
 
    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> list = service.getAllEmployees();
 
        return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        EmployeeEntity entity = service.getEmployeeById(id);
 
        return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }
 
    @PostMapping()
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@Valid @RequestBody EmployeeEntity employee)
                                                    throws RecordNotFoundException {
        EmployeeEntity updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeEntity> UpdateEmployee(@PathVariable Long id , @RequestBody EmployeeEntity employee)
                                                    throws RecordNotFoundException {
        EmployeeEntity updated = service.UpdateEmployee(id,employee);
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }
    
    
	/*
	 * @PatchMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<?> partialUpdateGeneric(
	 * 
	 * @RequestBody Map<String, Object> updates,
	 * 
	 * @PathVariable("id") Long id) {
	 * 
	 * service.save(updates, id); return ResponseEntity.ok("resource updated"); }
	 */
}