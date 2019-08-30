package com.leagueOfCoders.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.leagueOfCoders.bank.models.Account;
import com.leagueOfCoders.bank.models.Transaction;


public interface TransactionService {
	List<Transaction> listAll();

	Transaction saveTransaction(Transaction transaction);

	Transaction findById(long id);
	
	Optional<List<Transaction>> findByFromAccountId(long id);

	Optional<List<Transaction>> findByToAccountId(long id);

}
