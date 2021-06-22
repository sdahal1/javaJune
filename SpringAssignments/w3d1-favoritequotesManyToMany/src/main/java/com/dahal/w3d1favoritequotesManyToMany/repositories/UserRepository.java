package com.dahal.w3d1favoritequotesManyToMany.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dahal.w3d1favoritequotesManyToMany.models.Quote;
import com.dahal.w3d1favoritequotesManyToMany.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	//THIS IS NEW FOR THE NON FAVORITE USERS
	List<User> findByfavQuotesNotContaining(Quote q);
}
