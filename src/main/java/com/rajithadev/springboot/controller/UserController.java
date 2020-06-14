package com.rajithadev.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajithadev.springboot.model.User;
import com.rajithadev.springboot.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//@Autowired
	//private BCryptPasswordEncoder passwordEncoder;
	
	
	@RequestMapping("/register")
	public User register(@RequestBody User user) throws Exception {
		String tempEmailid = user.getEmail();
		//String pwd = user.getPassword();
		//String encryptedPwd = passwordEncoder.encode(pwd);
		//user.setPassword(encryptedPwd);
		if(tempEmailid != null && !"".equals(tempEmailid)) {
			User userObj = userService.fetchUserByEmailId(tempEmailid);
			if(userObj != null) {
				throw new Exception("User with "+tempEmailid+" is already exist!");
			}
			
		}
		
		User userObj = null;
		userObj = userService.adduser(user);
		return userObj;
	}
	
	@RequestMapping("/login")
	public User login(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmail();
		String tempPassword = user.getPassword();
		User userObj = null;
		
		if(tempEmailId != null && tempPassword != null) {
			userObj = userService.fetchUserByEmailIdAndPassword(tempEmailId, tempPassword);
			
		}
		if(userObj == null) {
			throw new Exception("Email or Password is incorrect!");
		}
		return userObj;
		
		
	}
}
