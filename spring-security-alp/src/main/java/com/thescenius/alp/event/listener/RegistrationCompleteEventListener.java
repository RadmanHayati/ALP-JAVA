package com.thescenius.alp.event.listener;

import com.thescenius.alp.entity.User;
import com.thescenius.alp.event.RegistrationCompleteEvent;
import com.thescenius.alp.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create verification token for the user with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        // Send email to the user
        //Send Mail to user
        String url =
                event.getApplicationUrl()
                        + "/verifyRegistration?token="
                        + token;

        //sendVerificationEmail()
        log.info("Click the link to verify your account: {}",
                url);
    }
}
