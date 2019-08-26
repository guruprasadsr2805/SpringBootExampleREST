package com.example.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.restservices.entities.Order;
import com.example.restservices.entities.User;
import com.example.restservices.exceptions.UserNameNotFoundException;
import com.example.restservices.repositories.OrderRepository;
import com.example.restservices.repositories.UserRepository;

@RestController
@RequestMapping(path = "/users")
public class OrderController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	//get All orders for a user method
	@GetMapping(path = "/{userid}/orders")
	public List<Order> getAllOrdersForAUsers(@PathVariable("userid") Long userid) throws UserNameNotFoundException{
		
		Optional<User> optionalUser = userRepository.findById(userid);
		if(!optionalUser.isPresent())
			throw new UserNameNotFoundException("User with userid:"+userid+" not found");
		return optionalUser.get().getOrder();
	}
	
	//get All orders for a user method
	@PostMapping(path = "/{userid}/orders")
	public Order createOrder(@PathVariable("userid") Long userid,@RequestBody Order order) throws UserNameNotFoundException {
		Optional<User> optionalUser = userRepository.findById(userid);
		if(!optionalUser.isPresent())
			throw new UserNameNotFoundException("User with userid:"+userid+" not found");
		
		
		User user = optionalUser.get();
		order.setUser(user);
		return orderRepository.save(order);
	}
	
	//get All orders for a user method
		@GetMapping(path = "/{userid}/orders/{orderid}")
		public Order getOrderByOrderId(@PathVariable("userid") Long userid,@PathVariable("orderid") Long orderid) throws UserNameNotFoundException{
			
			Optional<User> optionalUser = userRepository.findById(userid);
			if(!optionalUser.isPresent())
				throw new UserNameNotFoundException("User with userid:"+userid+" not found");
			
			User user = optionalUser.get();
			List<Order> orderList = user.getOrder();
			int actual = -1;
			for(int i = 0; i< orderList.size()-1; i++) {
				if(orderList.get(i).getOrderid() == orderid)
					actual=i;
				else
					continue;
			}
			
			if(!(actual >=0))
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"There is no order with orderid:"+orderid+", for the user:"+userid);
			
			return orderList.get(actual);
		}

}
