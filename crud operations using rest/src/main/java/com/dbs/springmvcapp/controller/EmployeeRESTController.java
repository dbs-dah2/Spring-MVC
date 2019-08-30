package com.dbs.springmvcapp.controller;

import com.dbs.springmvcapp.model.Employee;
import com.dbs.springmvcapp.repository.EmployeeRepository;
import com.dbs.springmvcapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.MediaType;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = {"/api/v1/"})
public class EmployeeRESTController {

    @Autowired
    private EmployeeService employeeService;
    
    private EmployeeRepository repository;

    EmployeeRESTController(EmployeeRepository employeeRepository) {
        this.repository = employeeRepository;
    }

    @GetMapping(value = "/employees")
    public List<Employee> listAll(){
        System.out.println("Inside the list all method....");
        return this.employeeService.listAll();
    }

//    @GetMapping(path = {"/employees/{id}"})
//    public Employee findEmployeeById(@PathVariable("id") long id){
//        return this.employeeService.findById(id);
//    }
    
    @GetMapping(path = {"/employees/{id}"})
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") long id){
        return this.employeeService.findById(id);
    }

    @PostMapping("/employees")
    public void saveEmployee(@Valid @RequestBody Employee employee){
        this.employeeService.saveEmployee(employee);
    }
    
    @PutMapping(value="/employees/{id}",headers="Accept=application/json")
    public ResponseEntity<Employee> update(@PathVariable long id,@RequestBody Employee employee){
    	System.out.println(employee);
      return this.employeeService.update(id,employee);
    }
    
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
      return this.employeeService.deleteEmployee(id);
    }
    
    
}