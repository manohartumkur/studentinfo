package com.finonyx.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finonyx.app.model.HelloWorld;

@RestController
public class HelloController {

	@RequestMapping(value = "/v1/greet")
	public String greet() {
		
		return "Hello World";
		
		
	}
	
	@GetMapping(value = "/v1/greetbean")
	public HelloWorld greetBean() {
		
		return new HelloWorld("Hello World");
		
		
	}
	
	@GetMapping(value = "/v1/greetbean/{name}")
	public HelloWorld greetBeanPathVariable(@PathVariable String name) {
		
		return new HelloWorld("Hello "+name.toUpperCase()+". Good Morning");
		
		
	}
}
