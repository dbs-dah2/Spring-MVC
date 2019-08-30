package com.leagueOfCoders.bank.service;

import java.util.List;
import java.util.Optional;

import com.leagueOfCoders.bank.models.Banker;

public interface BankerService {


    List<Banker> listAll();

    Banker findById(long empId);

    Optional<Banker> findByAdminNameAndPassword(String name,String pwd);
    
    Banker saveBanker(Banker banker);
}