package com.thescenius.alp.repository;

import com.thescenius.alp.entity.User;
import com.thescenius.alp.entity.VerificationToken;
import com.thescenius.alp.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    Collection<Word> findByTitleAndUser(String title, User user);

    Collection<Word> findByUser(User user);

    Optional<Word> findByIdAndUser(Integer id, User user);

    void deleteByIdAndUser(Integer id, User user);

}