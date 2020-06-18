package com.rajithadev.springboot.message.response;

import java.util.Optional;


import com.rajithadev.springboot.model.User;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Optional<User> userData;

	public JwtResponse(String token, Optional<User> userObj) {
		super();
		this.token = token;
		this.userData = userObj;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Optional<User> getUserData() {
		return userData;
	}

	public void setUserData(Optional<User> userData) {
		this.userData = userData;
	}

}