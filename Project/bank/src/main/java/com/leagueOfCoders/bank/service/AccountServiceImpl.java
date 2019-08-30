package com.leagueOfCoders.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.leagueOfCoders.bank.models.Account;
import com.leagueOfCoders.bank.models.CustomerDetails;
import com.leagueOfCoders.bank.repository.AccountRepository;
import com.leagueOfCoders.bank.repository.CustomerRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	
    @Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public List<Account> findByCustomer(CustomerDetails id) {
		return this.accountRepository.findByCustomer(id);
	}

	@Override
	public List<Account> listAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account saveAccount(CustomerDetails id,Account account) {
		List<Account> accounts = findByCustomer(id);
		for(Account acc : accounts) {
		      if(acc.getAccountType().equalsIgnoreCase("joint")) {
		    	 System.out.println();
		         System.out.println("Sorry you already have " + acc.getAccountType() + " account type");
		         System.out.println();
		         System.out.println();
		         return null;
		      }
		      
		   }
		return accountRepository.save(account);
		
	}

	@Override
	public Account findById(long id) {
		return accountRepository.findById(id).get();
	}

	@Override
	public Account updateAccount(long id, Account accountDetails) {
		Account account = accountRepository.findById(id).get();
		account.setAccountType(accountDetails.getAccountType());
		account.setBranch(accountDetails.getBranch());
		return accountRepository.save(account);
	}

	@Override
	public ResponseEntity<?> deleteAccount(long id) {
		Account account = accountRepository.findById(id).get();
		accountRepository.delete(account);
		return ResponseEntity.ok().build();
	}

}
