package com.javainterviewpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @RequestMapping("/user")
    public String welcomeUser()
    {
        return "User has successfully logged in!!!";

    }

    @RequestMapping("/admin")
    public String welcomeAdmin()
    {
        return "Admin has successfully logged in!!!";
    }
}
