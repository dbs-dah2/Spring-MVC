package com.dbs.bank.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dbs.bank.model.Customer;
import com.dbs.bank.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    
    @Override
    @Transactional
    public List<Customer> listAll(){
    	return customerRepository.findAll();
    }
    
    @Override
    @Transactional
    public String saveCustomer(Customer customer) {
    	if((customerRepository.findByPanID(customer.getPanID())==null)
    			&& (customerRepository.findByEmail(customer.getEmail())==null)
    					&& (customerRepository.findByPhoneNumber(customer.getPhoneNumber())==null))
    	{
    		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
    		System.out.println("\n\n\n encrypted pass = " + customer.getPassword()+"\n\n\n");
    	customerRepository.save(customer);
    	return "Customer details added";
    	}
    	else
    	{
    	String result="";
    	if(customerRepository.findByPanID(customer.getPanID())!=null) {
    		result+="PAN ID ";
    	}
    	if(customerRepository.findByEmail(customer.getEmail())!=null) {
    		result+="Email ";
    	}
    	if(customerRepository.findByPhoneNumber(customer.getPhoneNumber())!=null) {
    		result+="Phone Number";
    	}
    	return result+" Exists";
    	}
    }
    
    @Override
    @Transactional
    public Customer findById(long id) {
    	return this.customerRepository.findById(id).get();
    }
    
    @Override
    @Transactional
    public ResponseEntity<Customer> updateCustomer(long id,Customer customerDetails) {
    	Customer customer = customerRepository.findById(id).get();
    	
    	customer.setPassword(customerDetails.getPassword());
    	customer.setFirstname(customerDetails.getFirstname());
    	customer.setLastname(customerDetails.getLastname());
    	customer.setEmail(customerDetails.getEmail());
    	customer.setPhoneNumber(customerDetails.getPhoneNumber());
    	customer.setPanID(customerDetails.getPanID());
    	
    	return ResponseEntity.ok().body(customer);
    	
    }
    
    @Override
    @Transactional
	public Customer findByPanId(String panId) {
		// TODO Auto-generated method stub
		return customerRepository.findByPanID(panId);
	}

	@Override
	@Transactional
	public Customer findByEmail(String email) {
		// TODO Auto-generated method stub
		return customerRepository.findByEmail(email);
	}

	@Override
	@Transactional
	public Customer findByPhoneNum(String phoneNum) {
		// TODO Auto-generated method stub
		return customerRepository.findByPhoneNumber(phoneNum);
	}
    
    @Override
    @Transactional
    public ResponseEntity<?> deleteCustomer(long id){
    	Customer customer = customerRepository.findById(id).get();
    	customerRepository.delete(customer);
    	return ResponseEntity.ok().build();
    }
    
    @Override
    @Transactional
	public Optional<Customer> findByEmailAndPassword(String email, String password) {
		return this.customerRepository.findByEmailAndPassword(email, password);
	}
}
