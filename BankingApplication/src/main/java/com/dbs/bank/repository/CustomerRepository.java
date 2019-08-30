package com.dbs.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dbs.bank.model.Customer;

@CrossOrigin
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	public Customer findByPanID(String panID);
	public Customer findByEmail(String email);
	public Customer findByPhoneNumber(String phoneNumber);
	Optional<Customer> findByEmailAndPassword(String email, String password);
}
