package com.dbs.twitter.model;

import java.util.List;

import javax.persistence.*;


import lombok.Data;

@Data
@Entity
@Table
public class Tweets {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "tweet", nullable = false)
    private String tweet;
    
    @Column(name = "media_url", nullable = false)
    private String mediaUrl;
    
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

	public Tweets(String user_tweet, String mediaUrl) {
		super();
		this.tweet = user_tweet;
		this.mediaUrl = mediaUrl;
		
	}

	
	

    


	
//	public Tweets(long id, String user_tweet, String mediaUrl) {
//		super();
//		this.id = id;
//		this.user_tweet = user_tweet;
//		this.mediaUrl = mediaUrl;
//	}

	
    
    
}