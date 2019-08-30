package com.dbs.twitter.service;

import com.dbs.twitter.model.Tweets;
import com.dbs.twitter.model.User;

public interface UserService {
	User saveUser(User user);

	Tweets saveTweet(Tweets tweet);

	User findById(long id);

	User saveTweet(User user);

}
