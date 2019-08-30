package com.dbs.emp_mgmt.dao;

import com.dbs.emp_mgmt.model.Employee;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("inMemory")

public class InMemoryEmployeeDAOImpl implements EmployeeDAO {

    private static final List<Employee> empList = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        empList.add(employee);
        System.out.println("Saved the employee in the in Memory list "+employee);
        return employee;
    }

    @Override
    public Employee update(long empId, Employee employee) {
        Optional<Employee> optionalEmp = empList.stream().filter(emp -> emp.getId() == empId).findFirst();
        optionalEmp.ifPresent(employee1 -> empList.add(empList.indexOf(employee), employee));
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return empList;
    }

    @Override
    public Employee findById(long id) {
        Optional<Employee> optionalEmployee = empList.stream().filter(employee -> employee.getId() == id).findFirst();
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }
        return null;
    }

    @Override
    public void deleteEmployee(long id) {
        empList.removeIf(employee -> employee.getId() == id);
    }

	@Override
	public List<Employee> findAllMysql() {
		// TODO Auto-generated method stub
		return null;
	}
}