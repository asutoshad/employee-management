package com.bway.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.web.model.User;
import com.bway.web.repository.UserRepository;
import com.bway.web.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public void userSignup(User user) {

		userRepo.save(user);
		
	}

	@Override
	public User userLogin(String email, String psw) {
		
		return userRepo.findByEmailAndPassword(email,psw);
		
	}

	@Override
	public User isUserExist(String email) {
		
		return userRepo.findByEmail(email);
		
	}

	 

}
