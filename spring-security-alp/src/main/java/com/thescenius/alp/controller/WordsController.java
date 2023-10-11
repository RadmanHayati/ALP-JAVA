package com.thescenius.alp.controller;

import com.thescenius.alp.entity.Word;
import com.thescenius.alp.repository.WordRepository;
import com.thescenius.alp.service.user.AuthenticationService;
import com.thescenius.alp.service.word.WordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/words")
public class WordsController {

    @Autowired
    WordService wordService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Word> words() {
        return wordService.findAllUserWords();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Word getWordById(@PathVariable("id") Integer id) {
        return wordService.findUserWordById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void saveWord(@RequestBody @Valid Word word) {
        word.setId(null);
        wordService.addWord(word);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteTask(@PathVariable("id") Integer id) {
        wordService.deleteWord(id);
    }

/*    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void editTask(@RequestBody @Valid Tasks editedTask, @PathVariable("id") Long id) {
        editedTask.setId(id);
        tasksRepository.saveAndFlush(edited
    }*/
}
