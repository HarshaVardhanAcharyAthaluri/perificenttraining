package com.training.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	UserRepository repo;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return (List<User>) repo.findAll();
	}
	
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User u ) {
		return repo.save(u);
	}

}
