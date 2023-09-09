package com.thescenius.alp.service;

import com.thescenius.alp.entity.PasswordResetToken;
import com.thescenius.alp.entity.Role;
import com.thescenius.alp.entity.User;
import com.thescenius.alp.entity.VerificationToken;
import com.thescenius.alp.model.UserModel;
import com.thescenius.alp.repository.PasswordRestTokenRepository;
import com.thescenius.alp.repository.UserRepository;
import com.thescenius.alp.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private PasswordRestTokenRepository passwordResetTokenRepository;

    @Override
    public User registerUser(UserModel userModel) {
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFirstname(userModel.getFirstName());
        user.setLastname(userModel.getLastName());
        user.setRole(Role.USER);
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationTokenRepository.save(verificationToken);
    }

    @Override
    public String validateVerificationToken(String token) {
        // Check if token exists
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        if (verificationToken == null) {
            return "Invalid";
        }
        User user = verificationToken.getUser();

        // Check if token is not expired
        Calendar cal = Calendar.getInstance();
        if (verificationToken.getExpirationTime().getTime()
                - cal.getTime().getTime() <= 0
        ) {
            verificationTokenRepository.delete(verificationToken);
            return "Expired";
        }
        user.setEnabled(true);
        userRepository.save(user);
        return "Valid";
    }

    @Override
    public VerificationToken generateNewVerificationToken(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        VerificationToken verificationToken
                = verificationTokenRepository.findByUser(user);
        verificationToken.setToken(UUID.randomUUID().toString());
        verificationTokenRepository.save(verificationToken);
        return verificationToken;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken passwordResetToken
                = new PasswordResetToken(user, token);
        passwordResetTokenRepository.save(passwordResetToken);
    }

    @Override
    public String validatePasswordResetToken(String token) {
        // Check if token exists
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);
        if (passwordResetToken == null) {
            return "Invalid";
        }
        User user = passwordResetToken.getUser();

        // Check if token is not expired
        Calendar cal = Calendar.getInstance();
        if (passwordResetToken.getExpirationTime().getTime()
                - cal.getTime().getTime() <= 0
        ) {
            passwordResetTokenRepository.delete(passwordResetToken);
            return "Expired";
        }
        return "Valid";
    }

    @Override
    public Optional<User> getUserByPasswordResetToken(String token) {
        return Optional.ofNullable(passwordResetTokenRepository.findByToken(token).getUser());
    }

    @Override
    public void changePassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }


    @Override
    public boolean checkIfValidOldPassword(User user, String oldPassword) {
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

}
