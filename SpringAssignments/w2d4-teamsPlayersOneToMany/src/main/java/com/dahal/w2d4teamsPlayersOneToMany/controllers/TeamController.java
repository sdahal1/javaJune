package com.dahal.w2d4teamsPlayersOneToMany.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dahal.w2d4teamsPlayersOneToMany.models.Team;
import com.dahal.w2d4teamsPlayersOneToMany.services.AppService;

@Controller
public class TeamController {
	
	private final AppService appService;
	
	public TeamController(AppService appService) {
		this.appService= appService;
	}

	@GetMapping("/")
	public String welcomeToTeam(Model model) {
		List<Team> allTeams = this.appService.findAllTeams();
		model.addAttribute("allTeams", allTeams);
		return "index.jsp";
	}
	
}
