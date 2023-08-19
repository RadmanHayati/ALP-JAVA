package com.thescenius.alp.controller;

import com.thescenius.alp.entity.User;
import com.thescenius.alp.event.RegistrationCompleteEvent;
import com.thescenius.alp.model.UserModel;
import com.thescenius.alp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request) {
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(
                user,
                applicationUrl(request)
        ));
        return "Success";
    }

    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token) {
        String result = userService.validateVerificationToken(token);
        if (result.equalsIgnoreCase("valid")) {
            return "User Verified Successfully";
        }
        return "Bad User";
    }


    private String applicationUrl(HttpServletRequest request) {
        return "http://" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
    }

}
