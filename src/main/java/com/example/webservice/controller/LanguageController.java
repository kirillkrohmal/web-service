package com.example.webservice.controller;


import com.example.webservice.Replay;
import com.example.webservice.ReplayOk;
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
    public ResponseEntity<Replay> createLanguage(@Valid @RequestBody Languages languages) {
        try {
            Languages language = languageService
                    .save(new Languages(languages.getId(), languages.getName(), languages.getDescription(), languages.getRating()));

            Replay replay = new Replay();
            replay.state = "ok";
            replay.body = language;

            return new ResponseEntity<>(replay, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/language/{name}")
    public ResponseEntity<Replay> updateLanguage(@PathVariable(value = "name") String languageByName,
                           @Valid @RequestBody Languages languages) {

        Languages language = languageService.getLanguageByName(languageByName);


        try {

            if(languages.getName() != null) {
                language.setName(languages.getName());
            }

            if(languages.getDescription() != null) {
                language.setDescription(languages.getDescription());
            }

            if(languages.getRating() != 0) {
                language.setRating(languages.getRating());
            }

            language = languageService.save(language);

            Replay replay = new Replay();
            replay.state = "ok";
            replay.body = language;

            return new ResponseEntity<>(replay, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/language/{name}")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ReplayOk> deleteBook(@PathVariable(value = "name") String languageByName) {
        Languages language = languageService.getLanguageByName(languageByName);

        languageService.delete(language);

        ReplayOk replay = new ReplayOk();
        replay.state = "ok";

        return new ResponseEntity<>(replay, HttpStatus.CREATED);
    }
}
