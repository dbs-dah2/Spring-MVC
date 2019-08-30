package com.leagueOfCoders.bank.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.leagueOfCoders.bank.models.Account;
import com.leagueOfCoders.bank.models.CustomerDetails;
import com.leagueOfCoders.bank.service.AccountService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping("/account")
	public List<Account> getAllAccounts(){
		return accountService.listAll();
	}
	
	@PostMapping("customer/{id}/account")
	public Account createAccount(@RequestBody Account account,@PathVariable("id") CustomerDetails id) {
		return accountService.saveAccount(id,account);
	}
	
	@GetMapping("account/{id}")
	public Account getAccountById(@PathVariable("id") Long id) {
		return accountService.findById(id);
	}
	
	@GetMapping("customer/{id}/account")
	public List<Account> getAccountByCustomerId(@PathVariable("id") CustomerDetails id) {
		return accountService.findByCustomer(id);
	}
		
	@PutMapping("/account/{id}")
	public Account updateAccount(@PathVariable("id") Long id,
			@Valid @RequestBody Account accountDetails) {
		return accountService.updateAccount(id, accountDetails);
	}
	
	@DeleteMapping("/account/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable("id") Long id){
		return accountService.deleteAccount(id);
	}
}
