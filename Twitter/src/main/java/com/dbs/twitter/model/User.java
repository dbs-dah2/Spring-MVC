package com.dbs.twitter.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;


import lombok.Data;

@Data
@Entity
@Table
public class User {
	
	public User() {}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
    private long id;

    @Column(name = "user_name", nullable = false)
    private String name;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "email_id", nullable = false)
    private String email;
    
    @Column(name = "phone", nullable = true)
    private long phone;
    
    @Column(name = "city", nullable = true)
    private String city;
    
    @Column(name = "state", nullable = true)
    private String state;
    
    @Column(name = "pincode", nullable = true)
    private long pincode;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Tweets> tweets = new HashSet<>();
	

	
    
	public void addUserTweets(Tweets tweet){
        this.tweets.add(tweet);
        tweet.setUser(this);
    }




	public User(long id, @NotBlank(message = "Name cannot be null") String name, String password, String email,
			long phone, String city, String state, long pincode, Set<Tweets> tweets) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.tweets = tweets;
	}
    
    
}
