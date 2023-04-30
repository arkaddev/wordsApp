package com.example.wordsApp.service;

import com.example.wordsApp.exception.WordDeleteException;
import com.example.wordsApp.exception.WordNotFoundException;
import com.example.wordsApp.exception.WordSaveException;
import com.example.wordsApp.model.Word;

import java.util.List;

public interface WordService {

    List<Word> getAllWords();

    Word getWordById(Long id) throws WordNotFoundException;

    Word createWord(Word word) throws WordSaveException;

    String deleteWord(Long id) throws WordDeleteException;

    Word updateWord(Long id, Word word);

    Word getRandomWord();
}
