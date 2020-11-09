package com.example.webservice.service;

import com.example.webservice.models.Languages;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface LanguageService {
    List<Languages> getLanguages();

    Languages save(Languages languages);

    void delete(Languages languages);

    Languages getLanguageByName(String name);
}
