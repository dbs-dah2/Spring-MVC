package com.leagueOfCoders.bank.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.leagueOfCoders.bank.models.CustomerDetails;
import com.leagueOfCoders.bank.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    
    @Override
    @Transactional
    public List<CustomerDetails> listAll(){
    	return customerRepository.findAll();
    }
    
    @Override
    @Transactional
    public CustomerDetails saveCustomer(CustomerDetails customer) {
    	return customerRepository.save(customer);
    }
    
    @Override
    @Transactional
    public CustomerDetails findById(long id) {
    	return this.customerRepository.findById(id).get();
    }
    
    @Override
    @Transactional
    public CustomerDetails updateCustomer(long id,CustomerDetails customerDetails) {
    	CustomerDetails customer = customerRepository.findById(id).get();
    	    	customer.setPassword(customerDetails.getPassword());
    	customer.setFirstname(customerDetails.getFirstname());
    	customer.setLastname(customerDetails.getLastname());
    	customer.setEmail(customerDetails.getEmail());
    	customer.setPhoneNumber(customerDetails.getPhoneNumber());
    	customer.setPanID(customerDetails.getPanID());
    	
    	return customerRepository.save(customer);
    	
    }
    
    @Override
    @Transactional
    public ResponseEntity<?> deleteCustomer(long id){
    	CustomerDetails customer = customerRepository.findById(id).get();
    	customerRepository.delete(customer);
    	return ResponseEntity.ok().build();
    }

	@Override
	public Optional<CustomerDetails> findByEmailAndPassword(String email, String password) {
		return this.customerRepository.findByEmailAndPassword(email, password);
	}
    
    
}
