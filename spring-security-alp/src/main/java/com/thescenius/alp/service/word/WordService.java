package com.thescenius.alp.service.word;

import com.thescenius.alp.entity.User;
import com.thescenius.alp.entity.Word;
import com.thescenius.alp.model.dto.WordDTO;

import java.util.Collection;

public interface WordService {

    Collection<Word> findAllWords();

    Collection<Word> findAllUserWords();

    Collection<Word>  findUserWordByTitle(String title);

    Word findUserWordById(Integer id);

    Word addWord(Word word);

    void editWord(Integer id , WordDTO word);

    Void deleteWord(Integer id);
}
