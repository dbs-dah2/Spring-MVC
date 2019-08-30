package com.leagueOfCoders.bank.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leagueOfCoders.bank.models.Banker;
import com.leagueOfCoders.bank.models.Branch;
import com.leagueOfCoders.bank.service.BankerService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class BankerRESTController {

    @Autowired
    private BankerService bankerService;

    @GetMapping(value = "/banker")
    public List<Banker> listAll(){
        System.out.println("Inside the list all method....");
        return this.bankerService.listAll();
    }
    
    @PostMapping("/banker")
    public Banker saveBanker(@Valid @RequestBody Banker banker) {
    	return this.bankerService.saveBanker(banker);
    }

    @GetMapping("/banker/{id}")
    public Banker findEmployeeById(@PathVariable("id") long id){
        return this.bankerService.findById(id);
    }

    
    @GetMapping("/banker/{name}/{pwd}")
    public Optional<Banker> findEmployeeByNameAndPassword(@PathVariable("name") String name,@PathVariable("pwd") String pwd){
        return this.bankerService.findByAdminNameAndPassword(name,pwd);
    }
}