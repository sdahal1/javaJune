package com.dahal.w3d1favoritequotesManyToMany.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dahal.w3d1favoritequotesManyToMany.models.Quote;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long> {

}
