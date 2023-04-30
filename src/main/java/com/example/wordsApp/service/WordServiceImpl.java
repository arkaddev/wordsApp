package com.example.wordsApp.service;

import com.example.wordsApp.model.Word;
import com.example.wordsApp.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class WordServiceImpl implements WordService {

    private final WordRepository wordRepository;

    @Autowired
    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public List<Word> getAllWords() {

        return wordRepository.findAll();
    }

    @Override
    public Word getWordById(Long id) {
        Optional<Word> optionalWord = wordRepository.findById(id);
        Word word = optionalWord.orElseThrow();
        return word;
    }

    @Override
    public Word createWord(Word word) {
        return wordRepository.save(word);
    }

    @Override
    public String deleteWord(Long id) {
        Word word = getWordById(id);
        wordRepository.delete(word);
        return "Word " + id + " deleted";
    }

    @Override
    public Word updateWord(Long id, Word word) {
        Word word1 = getWordById(id);
        word1.setEnglishWord(word.getEnglishWord());
        word1.setPolishWord(word.getPolishWord());

        return wordRepository.save(word1);
    }

    @Override
    public Word getRandomWord() {
        List<Word> wordList= wordRepository.findAll();

        Random random = new Random();
        int drawnNumber = random.nextInt(wordList.size());
        Word word = getWordById(Long.valueOf(drawnNumber+1));

        return word;
    }
}
