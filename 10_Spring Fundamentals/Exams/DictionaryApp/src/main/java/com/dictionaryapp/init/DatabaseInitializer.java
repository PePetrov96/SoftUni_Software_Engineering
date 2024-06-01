package com.dictionaryapp.init;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    private final LanguageRepository languageRepository;

    @Autowired
    public DatabaseInitializer(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (languageRepository.count() == 0) {
            initializeEntities();
        }
    }

    private void initializeEntities() {
        for (LanguageName languageName : LanguageName.values()) {
            Language language = new Language();

            language.setLanguageName(languageName);
            this.languageRepository.saveAndFlush(language);
        }
    }
}
