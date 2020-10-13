package com.project.employeemanagementapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.employeemanagementapi.model.DAOUser;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	
	DAOUser findByUsername(String username);
	
}