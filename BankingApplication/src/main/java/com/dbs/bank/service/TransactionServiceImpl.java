package com.dbs.bank.service;

import java.util.List;


import java.sql.Date;

import java.time.LocalDate;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dbs.bank.model.Account;
import com.dbs.bank.model.Transaction;
import com.dbs.bank.repository.AccountRepository;
import com.dbs.bank.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	

	@Autowired
	private TransactionRepository transactionRepository;
	
	public TransactionServiceImpl(TransactionRepository transactionRepository) {
		super();
		this.transactionRepository=transactionRepository;
	}
	
	@Autowired
	private AccountRepository accountRepository;

	
	@Override
	@Transactional
	public List<Transaction> listAll() {
		return this.transactionRepository.findAll();
	}
	
	
	@Override
	@Transactional
	public String saveTransaction(Transaction transaction) {
		
		List<Transaction> transactions=transactionRepository.findByFromAccountAndDate(transaction.getFromAccount(),Date.valueOf(LocalDate.now()));
		long sum=0;
		for(int i=0;i<transactions.size();i++) {
			sum=sum+transactions.get(i).getAmmount();
		}
		System.out.println("\n"+transactions+"\n"+sum);
			double fromAccountBalance = transaction.getFromAccount().getBalance();
	        double toAccountBalance = transaction.getToAccount().getBalance();
	        if((fromAccountBalance - transaction.getAmmount()) < 5000) {
	            return "Transaction cannot be done... Your account balance will be short of $5,000 with this transaction";
	        }
	        else {
		        transaction.setDate(Date.valueOf(LocalDate.now())); 
	            fromAccountBalance = fromAccountBalance - transaction.getAmmount();
	            transaction.getFromAccount().setBalance(fromAccountBalance);
				
	            if(sum+transaction.getAmmount()<=10000) {
	            	toAccountBalance = toAccountBalance + transaction.getAmmount();
	            	transaction.getToAccount().setBalance(toAccountBalance);
	            	transactionRepository.save(transaction);
			        return "Transaction successfull";
	            }
	            else {
	            	transaction.setFlag(true);
			        transactionRepository.save(transaction);
			        return "Transaction limit exceeded/ Awaiting Bank Approval";
	            }
	        }
	}

	@Override
	@Transactional
	public ResponseEntity<Transaction> updateTransaction(Transaction transaction) {
		
		if(transaction.isFlag()) {
			double toAccountBalance = transaction.getToAccount().getBalance();
			
			toAccountBalance = toAccountBalance + transaction.getAmmount();				
			transaction.getToAccount().setBalance(toAccountBalance);
			transaction.setFlag(false);
			this.accountRepository.save(transaction.getToAccount());
			return ResponseEntity.ok().body(transaction);
		}
		return null;
	}

	@Override
	@Transactional
	public List<Transaction> findByFromAccount(Account id) {
		return this.transactionRepository.findByFromAccount(id);
	}

	@Override
	@Transactional
	public Transaction findById(long id) {
		return this.transactionRepository.findById(id).get();
	}

	@Override
	@Transactional
	public List<Transaction> findByToAccount(Account id) {
		return this.transactionRepository.findByToAccount(id);
		
	}

}