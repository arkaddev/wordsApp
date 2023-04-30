package com.example.wordsApp.service;

import com.example.wordsApp.model.Word;

import java.util.List;

public interface WordService {

    List<Word> getAllWords();
    Word getWordById(Long id);
    Word createWord(Word word);
    String deleteWord(Long id);
    Word updateWord(Long id, Word word);
    Word getRandomWord();
}
