package com.dahal.w2d4teamsPlayersOneToMany.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dahal.w2d4teamsPlayersOneToMany.models.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

}
