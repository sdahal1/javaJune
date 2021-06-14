package com.dahal.springIntro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HelloController {
	//route for localhost:8080/greeting/
	@RequestMapping("/")
	public String sayHello() {
		return "Hello Everybody, welcome to spring!";
	}
	
	
	//route for localhost:8080/greeting/summer
	@RequestMapping("/summer")
	public String welcomeToSummer() {
		return "Welcome to summer, but we still coding in spring";
	}
	
	//route for localhost:8080/greeting/fall
	@RequestMapping(value= "/fall", method= RequestMethod.POST)
	public String welcomeToFall() {
		return "Welcome to fall, but we rise when we follow the 20 minute rule and put work in";
	}
}
