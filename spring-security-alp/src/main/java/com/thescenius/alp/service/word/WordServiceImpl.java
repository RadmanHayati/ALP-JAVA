package com.thescenius.alp.service.word;


import com.thescenius.alp.entity.User;
import com.thescenius.alp.entity.Word;
import com.thescenius.alp.model.dto.WordDTO;
import com.thescenius.alp.repository.WordRepository;
import com.thescenius.alp.service.user.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {
    @Autowired
    WordRepository wordRepository;
    @Autowired
    AuthenticationService authService;

    @Override
    public Collection<Word> findAllWords() {
        return null;
    }

    @Override
    public Collection<Word> findAllUserWords() {
        User user = authService.getUserWithAuthorities();
        return wordRepository.findByUser(user);
    }

    @Override
    public Collection<Word> findUserWordByTitle(String title) {
        User user = authService.getUserWithAuthorities();
        return wordRepository.findByTitleAndUser(title, user);
    }

    @Override
    public Word findUserWordById(Integer id) {
        User user = authService.getUserWithAuthorities();
        Optional<Word> optionalWord = wordRepository.findByIdAndUser(id, user);
        if (optionalWord.isPresent()) {
            return optionalWord.get();
        } else {
            throw new IllegalArgumentException("Word not found or not owned by the user");
        }
    }

    @Override
    public Word addWord(Word word) {
        // TODO: 9/16/2023  word passed by user doesn't have ID will it cause a problem?
        // TODO: 9/16/2023  Do we need DTO?
        return wordRepository.save(word);
    }

    @Override
    public void editWord(Integer id, WordDTO newWord) {
        User user = authService.getUserWithAuthorities();
        Optional<Word> optionalWord = wordRepository.findByIdAndUser(id, user);
        if (optionalWord.isPresent()) {
            Word word = optionalWord.get();
            word.setTitle(newWord.getTitle());
            word.setMeaning(newWord.getMeaning());
            word.setImageURL(newWord.getImageURL());
            word.setUpdateDate(new Date());
            wordRepository.save(word);
        } else {
            throw new IllegalArgumentException("Word not found or not owned by the user");
        }
    }


    @Override
    public Void deleteWord(Integer id) {
        User user = authService.getUserWithAuthorities();
        wordRepository.deleteByIdAndUser(id, user);
        return null;
    }
}
