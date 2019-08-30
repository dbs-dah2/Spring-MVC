package com.leagueOfCoders.bank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leagueOfCoders.bank.models.Account;
import com.leagueOfCoders.bank.models.CustomerDetails;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	List<Account> findByCustomer(CustomerDetails id);
}
