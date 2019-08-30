package com.dbs.springmvcapp.controller;

import com.dbs.springmvcapp.model.Employee;
import com.dbs.springmvcapp.repository.EmployeeDAO;
import com.dbs.springmvcapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.time.LocalDate;
import java.util.Arrays;


@Controller
@RequestMapping("/users")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private EmployeeDAO dao;

    @GetMapping(value = "/")
    public String index(){
        return "index";
    }
    
    @GetMapping(value = "/login")
    public String loginPage(){
        return "login";
    }
    
    @GetMapping(value = "/register")
    public String registrationPage(){
        return "register";
    }
    
    @PostMapping("/loginUser")
    public String loginUser(
            @RequestParam("username")String username,
            @RequestParam("password") String password,
            Model model,Employee employee){
    	
    	int isRegistered = 0;
    	
        System.out.println("Inside the POST method of login user");
        System.out.println("Username is "+username + " password is "+ password);
        
        if(username.equalsIgnoreCase(password)) {
        	//System.out.println(dao.findById(employee.getId()).isPresent());
        	if(!(dao.findById(employee.getId()).isPresent())) {
        		System.out.println(!(dao.findById(employee.getId()).isPresent()));
        		isRegistered = 0;
                model.addAttribute("Registered", isRegistered);
                return "login";
            	         	
            }            	
            else {
//            	isRegistered = 0;
//                model.addAttribute("Registered", isRegistered);
//                return "login";
            	isRegistered = 1;
            	model.addAttribute("user", username);
                return "success";   
            }
        }
        else {
        	return "login";
        }
    }
    
    @PostMapping("/registerUser")
    public String RegisterUser(
            @RequestParam("name")String name,
            @RequestParam("dept_name") String department_name,
            Model model){
    	Employee employee = new Employee(name,LocalDate.of(1985,5, 25),department_name);
        this.employeeService.saveEmployee(employee);
        model.addAttribute("status", 1);
        return "register";
    }

    @GetMapping("/listAll")
    public String listAllEmployees(Model model){
        List<Employee>  employees=this.employeeService.listAll();
        model.addAttribute("employees", employees);
        return "list";
    }
}