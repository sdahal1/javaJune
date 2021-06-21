package com.dahal.w3d1favoritequotesManyToMany.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dahal.w3d1favoritequotesManyToMany.models.Quote;
import com.dahal.w3d1favoritequotesManyToMany.models.User;
import com.dahal.w3d1favoritequotesManyToMany.repositories.QuoteRepository;
import com.dahal.w3d1favoritequotesManyToMany.repositories.UserRepository;

@Service
public class AppService {
	
	private final QuoteRepository quoteRepo;
	private final UserRepository userRepo;
	
	public AppService(QuoteRepository quoteRepo, UserRepository userRepo) {
		this.quoteRepo= quoteRepo;
		this.userRepo = userRepo;
	}
	
	
	//find all quotes
	public List<Quote> findAllQuotes(){
		return (List<Quote>) this.quoteRepo.findAll();
	}
	
	//create a quote
	public Quote createQuote(Quote q) {
		return this.quoteRepo.save(q);
	}
	
	//get one quote
	public Quote getOneQuote(Long id) {
		return this.quoteRepo.findById(id).orElse(null);
	}
	
	//get all users so we can populate the dropdown
	public List<User> findAllUsers(){
		return (List<User>)this.userRepo.findAll();
	}
	
	//add a user as a favorite to a quote
	public void joinQuoteToUser(Long userId, Long quoteId) {
		User u = this.userRepo.findById(userId).orElse(null);
		Quote q = this.quoteRepo.findById(quoteId).orElse(null);
		
		//update the quote objects list of users who like it to add this user
		q.getUsersWhoLike().add(u);
		
		//save the newly updated quote object to the db
		this.quoteRepo.save(q);
	}

}
