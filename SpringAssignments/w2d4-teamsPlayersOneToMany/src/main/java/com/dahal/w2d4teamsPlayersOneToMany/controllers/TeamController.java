package com.dahal.w2d4teamsPlayersOneToMany.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dahal.w2d4teamsPlayersOneToMany.models.Player;
import com.dahal.w2d4teamsPlayersOneToMany.models.Team;
import com.dahal.w2d4teamsPlayersOneToMany.services.AppService;

@Controller
public class TeamController {
	
	private final AppService appService;
	
	public TeamController(AppService appService) {
		this.appService= appService;
	}

	@GetMapping("/")
	public String welcomeToTeam(Model model, @ModelAttribute("team") Team team) {
		List<Team> allTeams = this.appService.findAllTeams();
		model.addAttribute("allTeams", allTeams);
		return "index.jsp";
	}
	
	@PostMapping("/teams/create")
	public String createNewTeam(@Valid @ModelAttribute("team") Team team, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Team> allTeams = this.appService.findAllTeams();
			model.addAttribute("allTeams", allTeams);
			return "index.jsp";
		}else {
			this.appService.createTeam(team);
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/players/new")
	public String newPlayer(@ModelAttribute("player") Player player, Model model) {
		List<Team> allTeams = this.appService.findAllTeams();
		model.addAttribute("allTeams", allTeams);
		return "newPlayer.jsp";
	}
	
	@PostMapping("/players/create")
	public String createPlayer(@Valid @ModelAttribute("player") Player player, BindingResult result) {
		if(result.hasErrors()) {
			return "newPlayer.jsp";
		}else {
			this.appService.createPlayer(player);
			return "redirect:/";
		}
	}
	
	@GetMapping("/teams/{id}/info")
	public String teamInfo(@PathVariable("id") Long id, Model model) {
		//getting a team that we want to show info about
		Team t = this.appService.getTeam(id);
		
		model.addAttribute("teamtoshow", t);
		return "teamDetails.jsp";
	}
	
	
}
