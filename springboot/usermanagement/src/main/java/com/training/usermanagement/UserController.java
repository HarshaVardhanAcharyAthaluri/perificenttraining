package com.training.usermanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@Autowired
	UserRepository repo;

	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/list")
	public ModelAndView users() {
		ModelAndView mav = new ModelAndView();
		List<User> users =  (List<User>) repo.findAll();
		System.out.println(users);
		mav.addObject("users", users);
		mav.setViewName("userslist");
		return mav;
	} 
	
	@GetMapping("/adduser")
	public String addUser() {
		return "adduser";
	}

	@PostMapping("/save")
	public ModelAndView saveuser(User user) {
		repo.save(user);
		return users();
	}
}
