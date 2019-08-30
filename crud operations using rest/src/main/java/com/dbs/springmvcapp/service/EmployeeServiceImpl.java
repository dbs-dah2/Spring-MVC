package com.dbs.springmvcapp.service;


import com.dbs.springmvcapp.model.Employee;
import com.dbs.springmvcapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public List<Employee> listAll() {
        return this.employeeRepository.findAll();
    }

//    @Override
//    @Transactional
//    public Employee findById(long empId)  {
//        return this.employeeRepository.findById(empId).get();
//    }
    
    @Override
    @Transactional
    public ResponseEntity<Employee> update(long id,Employee employee){
      return employeeRepository.findById(id)
          .map(record -> {
              record.setName(employee.getName());
              record.setSalary(employee.getSalary());
              record.setAge(employee.getAge());
              Employee updated = employeeRepository.save(record);
              return ResponseEntity.ok().body(updated);
          }).orElse(ResponseEntity.notFound().build());
    }
    
    
    
    @Override
    @Transactional
    public ResponseEntity<Employee> findById(long empId)  {
        return employeeRepository.findById(empId).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @Override
    @Transactional
    public ResponseEntity<?> deleteEmployee(long empId) {
    	return employeeRepository.findById(empId)
                .map(record -> {
                	employeeRepository.deleteById(empId);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
    
    
}