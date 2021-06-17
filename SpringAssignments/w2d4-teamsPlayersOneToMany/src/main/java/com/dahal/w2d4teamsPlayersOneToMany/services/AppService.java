package com.dahal.w2d4teamsPlayersOneToMany.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dahal.w2d4teamsPlayersOneToMany.models.Player;
import com.dahal.w2d4teamsPlayersOneToMany.models.Team;
import com.dahal.w2d4teamsPlayersOneToMany.repositories.PlayerRepository;
import com.dahal.w2d4teamsPlayersOneToMany.repositories.TeamRepository;

@Service
public class AppService {
	//need to tell service about the repositories 
	private final TeamRepository teamRepo;
	
	private final PlayerRepository playerRepo;
	
	
	public AppService(TeamRepository teamRepo,PlayerRepository playerRepo ) {
		this.teamRepo = teamRepo;
		this.playerRepo = playerRepo;
	}
	
	//get all teams
	public List<Team> findAllTeams(){
		return (List<Team>)this.teamRepo.findAll();
	}
	
	//create a team
	public Team createTeam(Team t) {
		return this.teamRepo.save(t);
	}
	
	//create a player
	public Player createPlayer(Player p) {
		return this.playerRepo.save(p);
	}
	
	
	//get one team info
	public Team getTeam(Long id) {
		return this.teamRepo.findById(id).orElse(null);
	}
	
	
	

}
