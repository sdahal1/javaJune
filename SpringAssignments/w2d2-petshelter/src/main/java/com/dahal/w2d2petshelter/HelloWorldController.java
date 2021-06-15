package com.dahal.w2d2petshelter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/")
	public String greet() {
		return "home.jsp";
	}

}
