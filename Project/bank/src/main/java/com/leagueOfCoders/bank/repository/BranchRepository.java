package com.leagueOfCoders.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leagueOfCoders.bank.models.Branch;
import com.leagueOfCoders.bank.models.CustomerDetails;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long>{


}
