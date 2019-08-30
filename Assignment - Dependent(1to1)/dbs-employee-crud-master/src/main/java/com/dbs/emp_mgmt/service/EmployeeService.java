package com.dbs.emp_mgmt.service;

import com.dbs.emp_mgmt.model.Employee;
import java.util.List;

public interface EmployeeService {

   Employee saveEmployee(Employee employee);

   List<Employee> listAll();

   Employee findById(long empId);

   void deleteEmployee(long empId);
}