package com.example.wordsApp.controller;

import com.example.wordsApp.WordsAppApplication;
import com.example.wordsApp.model.Word;
import com.example.wordsApp.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
}
