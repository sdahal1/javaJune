package com.dahal.springIntro;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
	
	@RequestMapping("/search")
	public String searchForSomething(@RequestParam(value="q", required= false) String searchTerm) {
		System.out.println("*******************");
		System.out.println(searchTerm);
		System.out.println("*******************");
		if(searchTerm == null) {
			return "What do you seek young jedi?";
		}else {
			return "You searched for " + searchTerm;
			
		}
	}
	
	@RequestMapping("/users/{user_id}")
	public String displayUserDetails(@PathVariable("user_id") String idOfUser ) {
		return "Showing information about user #"+ idOfUser + " here";
	}
	
//	@RequestMapping("/users/2")
//	public String displayUser2Details() {
//		return "Showing information about user # 2 here";
//	}

}
