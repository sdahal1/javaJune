package com.dahal.languages.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dahal.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

}
