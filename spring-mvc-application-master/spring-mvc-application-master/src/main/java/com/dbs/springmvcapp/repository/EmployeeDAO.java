package com.dbs.springmvcapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.dbs.springmvcapp.model.Employee;

public interface EmployeeDAO extends CrudRepository<Employee, Long>{
	
}