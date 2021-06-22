package com.dahal.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dahal.languages.models.Language;
import com.dahal.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	//tell the service about the repository (tell the teller that he/she can use a machine to access money (repository to access db)
	private final LanguageRepository langRepo;
	
	//create a constructor to initialize the repository in the service
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	//method to find all languages
	public List<Language> findAllLanguages(){
		return (List<Language>)this.langRepo.findAll();
	}

}
