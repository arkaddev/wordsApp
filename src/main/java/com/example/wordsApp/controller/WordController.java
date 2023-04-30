package com.example.wordsApp.controller;

import com.example.wordsApp.model.Word;
import com.example.wordsApp.service.WordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Word", description = "Words that are in application")
@RestController
public class WordController {

    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @Operation(summary = "Displays all words.",
            description = "Displays all words, admin account required.",
            tags = "get")
    @GetMapping("/words")
    public List<Word> getAllWords() {
        return wordService.getAllWords();
    }

    @Operation(summary = "Displays a word by id.",
            description = "Displays a word by id, admin account required.")
    @GetMapping("/words/{id}")
    public Word getWordById(@PathVariable Long id) {
        return wordService.getWordById(id);
    }

    @Operation(summary = "Creates a new word.",
            description = "Creates a new word, admin account required.")
    @PostMapping("/words")
    public Word createWord(@RequestBody Word word) {
        return wordService.createWord(word);
    }

    @Operation(summary = "Removes a word.",
            description = "Removes a word from database, admin account required.")
    @DeleteMapping("/words/{id}")
    public String deleteWord(@PathVariable Long id) {
        return wordService.deleteWord(id);
    }

    @Operation(summary = "Updates a word.",
            description = "Updates a word, admin account required.")
    @PutMapping("/words/{id}")
    public Word updateWord(@PathVariable Long id, @RequestBody Word word) {
        return wordService.updateWord(id, word);
    }

    @Operation(summary = "Displays a random word.",
            description = "Displays a random word, user account required.")
    @GetMapping("/words/random")
    public Word getRandomWord() {
        return wordService.getRandomWord();
    }
}
