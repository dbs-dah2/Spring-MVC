package com.leagueOfCoders.bank.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.leagueOfCoders.bank.models.Account;
import com.leagueOfCoders.bank.models.Transaction;
import com.leagueOfCoders.bank.service.TransactionService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/transaction")
	public List<Transaction> getAllTransactions(){
		return transactionService.listAll();
	}
	
//	@GetMapping("transaction/{id}")
//	public Transaction getTransactionById(@PathVariable("id") Long id) {
//		return transactionService.findById(id);
//	}
	
	@PostMapping("/transaction")
	public Transaction createTransaction(@Valid @RequestBody Transaction transaction) {
		return transactionService.saveTransaction(transaction);
		
	}
	
	@GetMapping("customer/toAaccount/transaction/{id}")
	public Optional<List<Transaction>> getTransactionOfFromAccountNum(@PathVariable("id") long id) {
		return transactionService.findByFromAccountId(id);
	}
	
	@GetMapping("customer/fromAccount/transaction/{id}")
	public Optional<List<Transaction>> getTransactionOfToAccountNum(@PathVariable("id") long id) {
		return transactionService.findByToAccountId(id);
	}
	

}
