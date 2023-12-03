package com.bway.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.web.model.User;
import com.bway.web.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String gethome() {
		return "Index";
	}

	@GetMapping("/login")
	public String getLogin() {
		return "Login";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model) {
		User u = userService.userLogin(user.getEmail(), user.getPassword());
		if(u!= null) {
			model.addAttribute("uname" ,u.getUsername());
			return "Home";
		}
		model.addAttribute("message", "Something went wrong try again !!");
		return "Login";
		
	}
	
	@GetMapping("/signup")
	public String getSignup(@ModelAttribute User user,Model model) {
		//check user is already exist
		User u = userService.isUserExist(user.getEmail());
		
		if(u == null) {
			userService.userSignup(user);
		} else 
			model.addAttribute("message", "User already exist !!");
		
		return "Signup";
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User user,Model model) {
		//check user is already exist
		User u = userService.isUserExist(user.getEmail());
		
		if(u == null) {
			userService.userSignup(user);
		} else 
			model.addAttribute("message", "User already exist !!");
		
		return "Login";
	}
}
