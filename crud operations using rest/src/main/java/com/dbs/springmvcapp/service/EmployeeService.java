package com.dbs.springmvcapp.service;

import com.dbs.springmvcapp.model.Employee;
import java.util.List;

import org.springframework.http.ResponseEntity;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> listAll();

    ResponseEntity<Employee> findById(long empId);

    ResponseEntity<?> deleteEmployee(long empId);
    
    ResponseEntity<Employee> update(long id, Employee employee);

	//void deleteEmployee(long empId);

	
	//Employee update(Employee employee);
}
