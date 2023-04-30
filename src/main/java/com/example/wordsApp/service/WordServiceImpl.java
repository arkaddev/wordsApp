package com.example.wordsApp.service;

import com.example.wordsApp.exception.WordDeleteException;
import com.example.wordsApp.exception.WordNotFoundException;
import com.example.wordsApp.exception.WordSaveException;
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
    public Word getWordById(Long id) throws WordNotFoundException {
        Optional<Word> optionalWord = wordRepository.findById(id);

        return optionalWord.orElseThrow(() -> new WordDeleteException(id));
    }

    @Override
    public Word createWord(Word word) throws WordSaveException {
       try {
           return wordRepository.save(word);
       } catch (Exception e) {
           throw new WordSaveException();
       }

    }

    @Override
    public String deleteWord(Long id) throws WordDeleteException {
        Word word = getWordById(id);
        try {
            wordRepository.delete(word);
        } catch (Exception e) {
            throw new WordDeleteException(word.getId());
        }
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
        List<Word> wordList = wordRepository.findAll();

        Random random = new Random();
        int drawnNumber = random.nextInt(wordList.size());
        Word word = getWordById(Long.valueOf(drawnNumber + 1));

        return word;
    }
}
