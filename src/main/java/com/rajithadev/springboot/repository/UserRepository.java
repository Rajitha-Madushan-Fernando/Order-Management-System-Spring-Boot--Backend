package com.rajithadev.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajithadev.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
	
	User findByEmailAndPassword(String email, String password);

}
