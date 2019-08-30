package com.dbs.emp_mgmt.service;

import com.dbs.emp_mgmt.model.BankAccount;
import com.dbs.emp_mgmt.model.Employee;
import java.util.List;

public interface EmployeeService {

   Employee saveEmployee(Employee employee);
   
   BankAccount saveBankAccountDetails(BankAccount bankAccount);

   List<Employee> listAll();

   Employee findById(long empId);

   void deleteEmployee(long empId);
}