package com.dbs.twitter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.twitter.model.Tweets;

@Repository
public interface TweetRepository extends JpaRepository<Tweets, Long>{
	Optional<Tweets> findById(Long id);
    List<Tweets> findAll();
}
