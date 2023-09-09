package com.thescenius.alp.repository;

import com.thescenius.alp.entity.PasswordResetToken;
import com.thescenius.alp.entity.User;
import com.thescenius.alp.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRestTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);

    PasswordResetToken findByUser(User user);
}

