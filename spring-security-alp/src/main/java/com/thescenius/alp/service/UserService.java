package com.thescenius.alp.service;

import com.thescenius.alp.entity.User;
import com.thescenius.alp.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);
}
