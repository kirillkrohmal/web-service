package com.example.webservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.webservice.models.Languages;

@Repository
public interface LanguageRepository extends CrudRepository<Languages, Integer> {

    Languages findByName(String name);
}
