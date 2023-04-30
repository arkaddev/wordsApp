package com.example.wordsApp.controller;

import com.example.wordsApp.model.Word;
import com.example.wordsApp.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WordController {

    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/words")
    public List<Word> getAllWords() {
        return wordService.getAllWords();
    }

    @GetMapping("/words/{id}")
    public Word getWordById(@PathVariable Long id){
        return wordService.getWordById(id);
    }

    @PostMapping("/words")
    public Word createWord(@RequestBody Word word){
        return wordService.createWord(word);
    }

    @DeleteMapping("/words/{id}")
    public String deleteWord(@PathVariable  Long id){
        return wordService.deleteWord(id);
    }

    @PutMapping("/words/{id}")
    public Word updateWord(@PathVariable Long id, @RequestBody Word word){
        return wordService.updateWord(id, word);
    }

    @GetMapping("/words/random")
        public Word getRandomWord(){
            return wordService.getRandomWord();
        }
}
