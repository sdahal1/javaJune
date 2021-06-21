package com.dahal.w3d1favoritequotesManyToMany.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuotesController {

	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}
}
