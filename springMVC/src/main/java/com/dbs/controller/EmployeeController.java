package com.dbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class EmployeeController {

    @GetMapping("login")
    public String login(Model model){
        System.out.println("Came inside the login method ");

        return "login";
    }

    public String loginUser(){
        System.out.println("Inside the POST method of login user");
        return "sucess";
    }
}
