package com.example.webservice.controller;


import com.example.webservice.models.Languages;
import com.example.webservice.service.LanguageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class LanguageController {
    private LanguageServiceImpl languageService;

    @Autowired
    public LanguageController(LanguageServiceImpl languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/language")
    public List getAllLanguages() {
        return languageService.getLanguages();
    }

    @GetMapping("/language/{name}")
    public Languages getLanguageByName(@PathVariable(value = "name") String languageByName) {
        return languageService.getLanguageByName(languageByName);
    }

    @PostMapping("/language")
    public ResponseEntity<Languages> createLanguage(@Valid @RequestBody Languages languages) {
        try {
            Languages language = languageService
                    .save(new Languages(languages.getId(), languages.getName(), languages.getDescription(), languages.getRating()));
            return new ResponseEntity<>(language, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/language/{name}")
    public Languages updateLanguage(@PathVariable(value = "name") String languageByName,
                           @Valid @RequestBody Languages languages) {

        Languages language = languageService.getLanguageByName(languageByName);

        language.setName(languages.getName());
        language.setDescription(languages.getDescription());
        language.setRating(languages.getRating());

        return languageService.save(language);
    }

    @DeleteMapping("/language/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteBook(@PathVariable(value = "name") String languageByName) {
        Languages language = languageService.getLanguageByName(languageByName);

        languageService.delete(language);
        return ResponseEntity.ok().build();
    }
}
