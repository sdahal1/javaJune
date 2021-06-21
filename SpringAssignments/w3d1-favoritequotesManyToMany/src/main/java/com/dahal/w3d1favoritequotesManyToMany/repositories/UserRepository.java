package com.dahal.w3d1favoritequotesManyToMany.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dahal.w3d1favoritequotesManyToMany.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
