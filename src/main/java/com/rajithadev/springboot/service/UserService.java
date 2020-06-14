package com.rajithadev.springboot.service;


import com.rajithadev.springboot.model.User;

public interface UserService {

	User adduser(User user);
	
	User fetchUserByEmailId(String email);
	
	User fetchUserByEmailIdAndPassword(String email, String password);
}
