package com.example.restservices.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {
	
	//Simple Method
	//URI /helloworld
	//GET @RequestMapping or @GETMapping
	//@RequestMapping(method = RequestMethod.GET,path = "/helloworld")
	@GetMapping(path = "/helloworld1")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/helloworld-bean")
	public UserDetails helloworldbean() {
		return new UserDetails("Guruprasad", "S", "Bangalore");
	}

}
