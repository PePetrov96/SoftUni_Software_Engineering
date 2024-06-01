package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.WordBindingModel;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.entity.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.WordService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;
    private final UserRepository userRepository;
    private final LanguageRepository languageRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public WordServiceImpl(WordRepository wordRepository, UserRepository userRepository, LanguageRepository languageRepository, ModelMapper modelMapper) {
        this.wordRepository = wordRepository;
        this.userRepository = userRepository;
        this.languageRepository = languageRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addWord(WordBindingModel wordBindingModel, String username) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            Word word = modelMapper.map(wordBindingModel, Word.class);
            word.setAddedBy(user.get());

            LanguageName languageName = LanguageName.valueOf(wordBindingModel.getLanguage().toUpperCase());
            Language language = this.languageRepository.findByLanguageName(languageName);

            word.setLanguage(language);

            this.wordRepository.saveAndFlush(word);
        }
    }

    @Override
    public List<Word> getAllWordsForLanguage(String languageName) {
        return wordRepository.findAllByLanguage_LanguageName(LanguageName.valueOf(languageName.toUpperCase()));
    }

    @Override
    public void removeWord(Long id) {
        this.wordRepository.findById(id).ifPresent(this.wordRepository::delete);
    }

    @Override
    public void removeAllWords() {
        this.wordRepository.deleteAll();
    }
}
