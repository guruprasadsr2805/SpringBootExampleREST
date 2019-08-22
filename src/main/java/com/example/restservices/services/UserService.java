package com.example.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restservices.entities.User;
import com.example.restservices.repositories.UserRepository;

@Service
public class UserService {

	//Autowire user repository
	@Autowired
	private UserRepository userRepository;
	
	//GET All users
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//POST create user
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	//GET user by id
	public Optional<User> getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		//optional may or may not contain a value and wont give errors when null;
		return user;
	}
	
	//PUT user by id
	public User updateUserById(Long id,User user){
		user.setId(id);
		return userRepository.save(user);
	}
	
	//DELETE user by id
	public void deleteUserById(Long id) {
		if(userRepository.findById(id).isPresent())
			userRepository.deleteById(id);
	}
	
	//GET user by username
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
