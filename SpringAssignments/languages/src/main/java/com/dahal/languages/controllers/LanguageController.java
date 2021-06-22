package com.dahal.languages.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dahal.languages.models.Language;
import com.dahal.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService langService;
	
	public LanguageController(LanguageService langService) {
		this.langService = langService;
	}
	
	
	@GetMapping("/")
	public String home(Model model) {
		List<Language> allLangs = this.langService.findAllLanguages();
		
		model.addAttribute("allLangs", allLangs);
		return "index.jsp";
	}
	

}
