package com.leagueOfCoders.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leagueOfCoders.bank.models.CustomerDetails;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails, Long>{
  
	Optional<CustomerDetails> findByEmailAndPassword(String email,String password);
}
