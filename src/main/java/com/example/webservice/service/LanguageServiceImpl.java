package com.example.webservice.service;

import com.example.webservice.models.Languages;
import com.example.webservice.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;


@Service
public class LanguageServiceImpl implements LanguageService {
    private LanguageRepository languageRepository;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Languages> getLanguages() {
        return Lists.newArrayList(languageRepository.findAll());
    }

    @Override
    public Languages save(Languages languages) {
        return languageRepository.save(languages);
    }

    @Override
    public void delete(Languages languages) {
        languageRepository.delete(languages);
    }

    @Override
    public Languages getLanguageByName(String name) {
        return languageRepository.findByName(name);
    }
}
