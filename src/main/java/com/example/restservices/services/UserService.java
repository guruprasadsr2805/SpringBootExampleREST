package com.example.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.restservices.entities.User;
import com.example.restservices.exceptions.UserExistsException;
import com.example.restservices.exceptions.UserNotFoundException;
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
	public User createUser(User user) throws UserExistsException{
		User existingUser = userRepository.findByUsername(user.getUsername());
		if(existingUser!= null)
			throw new UserExistsException("User with username:"+user.getUsername()+" already exists");
		
		return userRepository.save(user);
	}
	
	//GET user by id
	public Optional<User> getUserById(Long id) throws UserNotFoundException{
		Optional<User> user = userRepository.findById(id);
		//optional may or may not contain a value and wont give errors when null;
		
		if(!user.isPresent())
			throw new UserNotFoundException("User with id:"+id+" not found");
		return user;
	}
	
	//PUT user by id
	public User updateUserById(Long id,User user) throws UserNotFoundException{
		Optional<User> optionalUser = userRepository.findById(id);
		if(!optionalUser.isPresent())
			throw new UserNotFoundException("User with id:"+id+" not found");
			
		user.setId(id);
		return userRepository.save(user);
	}
	
	//DELETE user by id
	public void deleteUserById(Long id) throws ResponseStatusException{
		Optional<User> optionalUser = userRepository.findById(id);
		if(!optionalUser.isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User with id:"+id+" not found");
		
		userRepository.deleteById(id);
	}
	
	//GET user by username
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
