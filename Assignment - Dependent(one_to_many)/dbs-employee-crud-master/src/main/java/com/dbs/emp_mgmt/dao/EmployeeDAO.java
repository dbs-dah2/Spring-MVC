package com.dbs.emp_mgmt.dao;

import com.dbs.emp_mgmt.model.Employee;
import java.util.List;

public interface EmployeeDAO {

    Employee save(Employee employee);

    Employee update(long empId, Employee employee);

    List<Employee> findAll();
    
    List<Employee> findAllMysql();

    Employee findById(long id);

    void deleteEmployee(long id);
}