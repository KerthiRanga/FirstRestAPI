package com.myfirst.springex.springController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@RequestMapping("/")
	public String display() {
		return "Hello world";
	}
	
	
}
