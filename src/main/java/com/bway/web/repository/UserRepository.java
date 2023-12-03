package com.bway.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.web.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmailAndPassword(String email, String psw);
	User findByEmail(String email);

}
