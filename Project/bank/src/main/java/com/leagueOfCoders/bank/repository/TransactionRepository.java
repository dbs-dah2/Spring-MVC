package com.leagueOfCoders.bank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leagueOfCoders.bank.models.Account;
import com.leagueOfCoders.bank.models.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{


	Optional<List<Transaction>> findByFromAccountId(long id);
	
	Optional<List<Transaction>> findByToAccountId(long id);
}
