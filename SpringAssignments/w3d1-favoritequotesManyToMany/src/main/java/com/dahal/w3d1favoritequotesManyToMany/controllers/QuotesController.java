package com.dahal.w3d1favoritequotesManyToMany.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dahal.w3d1favoritequotesManyToMany.models.Quote;
import com.dahal.w3d1favoritequotesManyToMany.models.User;
import com.dahal.w3d1favoritequotesManyToMany.services.AppService;

@Controller
public class QuotesController {
	private final AppService appService;
	
	public QuotesController(AppService appService) {
		this.appService = appService;
	}

	@GetMapping("/")
	public String home(Model model, @ModelAttribute("quote") Quote quote) {
		List<Quote> allQuotes = this.appService.findAllQuotes();
		
		model.addAttribute("allQuotes", allQuotes);
		
		
		return "home.jsp";
	}
	
	
	@PostMapping("/quotes/create")
	public String createQuote(@Valid @ModelAttribute("quote") Quote quote , BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Quote> allQuotes = this.appService.findAllQuotes();
			model.addAttribute("allQuotes", allQuotes);
			return "home.jsp";
		}else {
			this.appService.createQuote(quote);
			return "redirect:/";
		}
	}
	
	@GetMapping("/quotes/{id}/info")
	public String displayQuoteInfo(@PathVariable("id") Long id, Model model) {
		Quote q = this.appService.getOneQuote(id);
		model.addAttribute("quoteToShow", q);
		
		//get all the users so we can populate the dropdown with users to add to a quote's favoritors
		List<User> allUsers = this.appService.findAllUsers();
		
		model.addAttribute("allUsers", allUsers);
		
		//THIS IS NEW FOR THE NON FAVORITE USERS
		List<User> nonFavoriteUsers = this.appService.findUsersWhoAreNotFavoritorsOfQuote(q);
		model.addAttribute("nonFavUsers", nonFavoriteUsers);
		
		return "quoteInfo.jsp";
	}
	
	@PostMapping("/addUserToQuote/{id}")
	public String addUsertoQuote(@PathVariable("id")Long quoteid, @RequestParam("selected_user") Long userId ) {
		System.out.println("Id of the quote is this: " + quoteid);
		System.out.println("Id of the user is this: " + userId);
		this.appService.joinQuoteToUser(userId, quoteid);
		return "redirect:/";
		
	}
	
}
