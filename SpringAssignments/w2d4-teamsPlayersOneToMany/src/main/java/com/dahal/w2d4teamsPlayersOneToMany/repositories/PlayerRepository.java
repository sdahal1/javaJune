package com.dahal.w2d4teamsPlayersOneToMany.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dahal.w2d4teamsPlayersOneToMany.models.Player;


@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

}
