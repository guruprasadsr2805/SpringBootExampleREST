package com.example.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservices.entities.User;
import com.example.restservices.services.UserService;

@RestController
public class UserController {
	
	//Autowire the user service
	@Autowired
	private UserService userService;
	
	//get All users method
	@GetMapping(path = "/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	//POST a user
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	//GET a user
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id){
		return userService.getUserById(id);
	}
	
	//PUT update user by id
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
		return userService.updateUserById(id, user);
	}
	
	//DELETE user by id
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
	}
	
	//GET user by username
	@GetMapping("/users/byusername/{username}")
	public User findUserByUsername(@PathVariable("username") String username) {
		return userService.findUserByUsername(username);
	}
}
