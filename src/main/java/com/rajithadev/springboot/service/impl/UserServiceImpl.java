package com.rajithadev.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajithadev.springboot.model.User;
import com.rajithadev.springboot.repository.UserRepository;
import com.rajithadev.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	private UserRepository userRepository;
	
	@Autowired
	public  UserServiceImpl(UserRepository userRepository) {
		this.userRepository= userRepository;
	}
	
	@Override
	public User adduser(User user) {
		return userRepository.save(user);
	}


	@Override
	public User fetchUserByEmailId(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User fetchUserByEmailIdAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}


	
}
