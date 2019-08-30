package com.dbs.bank.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.bank.model.Banker;
import com.dbs.bank.repository.BankerRepository;


@Service
public class BankerServiceImpl implements BankerService{
	@Autowired
	private BankerRepository bankerRepository;
	
	public BankerServiceImpl(BankerRepository bankerRepository) {
		this.bankerRepository = bankerRepository;
	}


	@Override
	@Transactional
	public List<Banker> listAll() {
        return this.bankerRepository.findAll();
	}

	@Override
	@Transactional
	public Banker findById(long empId) {
        return this.bankerRepository.findById(empId).get();
	}


	@Override
	@Transactional
	public Optional<Banker> findByAdminNameAndPassword(String name, String pwd) {
		return this.bankerRepository.findByAdminNameAndPassword(name, pwd);
	}
}
