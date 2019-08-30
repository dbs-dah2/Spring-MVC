package com.dbs.twitter.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.twitter.model.Tweets;
import com.dbs.twitter.model.User;
import com.dbs.twitter.repository.TweetRepository;
import com.dbs.twitter.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TweetRepository tweetRepository;
	
	@Autowired
    public UserServiceImpl(UserRepository userRepository,TweetRepository tweetRepository){
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    @Override
    @Transactional
    public User saveTweet(User user) {
    	System.out.println("Hello");
    	return userRepository.save(user);
        //return tweetRepository.save(tweet);
    }
    
  @Override
  @Transactional
  public User findById(long id)  {
      return this.userRepository.findById(id).get();
  }

@Override
public Tweets saveTweet(Tweets tweet) {
	// TODO Auto-generated method stub
	return null;
}    
}
