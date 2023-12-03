package com.bway.web.service;

import com.bway.web.model.User;

public interface UserService {
	
	void userSignup(User user);
	User userLogin(String email, String psw);
	User isUserExist(String email);

}
