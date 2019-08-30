package com.leagueOfCoders.bank.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.leagueOfCoders.bank.models.CustomerDetails;
import com.leagueOfCoders.bank.service.CustomerService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
 
	@GetMapping("/customers")
	public List<CustomerDetails> getAllCustomers(){
		return customerService.listAll();
	}
	
	@PostMapping("/customers")
	public CustomerDetails createCustomer(@Valid @RequestBody CustomerDetails customer) {
		
		System.out.println(customer);
		return customerService.saveCustomer(customer);
		
	}
	
	@GetMapping("/customer/{id}")
	public CustomerDetails getCustomerById(@PathVariable("id") Long id) {
		return customerService.findById(id);
	}
	
	@PostMapping("/customer")
	public Optional<CustomerDetails> getCustomerByEmailAndPassword(@RequestBody CustomerDetails customer) {
		return customerService.findByEmailAndPassword(customer.getEmail(), customer.getPassword());
		//return customerService.findByEmailAndPassword(customer.get, password);
	}
	
	@PutMapping("/customer/{id}")
	public CustomerDetails updateCustomer(@PathVariable("id") Long id,
			@Valid @RequestBody CustomerDetails customerDetails) {
		return customerService.updateCustomer(id, customerDetails);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id){
		return customerService.deleteCustomer(id);
	}

}
