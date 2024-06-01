package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.WordBindingModel;
import com.dictionaryapp.model.entity.Word;

import java.util.List;

public interface WordService {
    void addWord(WordBindingModel wordBindingModel, String username);
    List<Word> getAllWordsForLanguage(String languageName);
    void removeWord(Long id);
    void removeAllWords();
}
