package com.leagueOfCoders.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leagueOfCoders.bank.models.Account;
import com.leagueOfCoders.bank.models.Transaction;
import com.leagueOfCoders.bank.repository.TransactionRepository;


@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepository;
	
	public TransactionServiceImpl(TransactionRepository transactionRepository) {
		super();
		this.transactionRepository=transactionRepository;
	}
	
	@Override
	public List<Transaction> listAll() {
		return this.transactionRepository.findAll();
	}

	@Override
	public Transaction saveTransaction(Transaction transaction) {
		return this.transactionRepository.save(transaction);
	}

	
	@Override
	public Optional<List<Transaction>> findByFromAccountId(long id) {
		return this.transactionRepository.findByFromAccountId(id);
	}

	@Override
	public Transaction findById(long id) {
		return this.transactionRepository.findById(id).get();
	}

	@Override
	public Optional<List<Transaction>> findByToAccountId(long id) {
		return this.transactionRepository.findByToAccountId(id);
		
	}

}
