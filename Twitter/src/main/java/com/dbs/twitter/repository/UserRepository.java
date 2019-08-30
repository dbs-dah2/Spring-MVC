package com.dbs.twitter.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.twitter.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
