package com.thescenius.alp.controller;


import com.thescenius.alp.entity.User;
import com.thescenius.alp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/demo-controller")
@RequiredArgsConstructor
public class HelloController {

    private final AuthenticationService service;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        Optional<User> user = service.getUserWithAuthorities();
        if (user.isPresent()) {
            String object = user.get().getEmail();
            return ResponseEntity.ok("Hello from secured endpoint " + object);
            // Access properties of object
        } else {
            return ResponseEntity.ok("Hello from secured endpoint");
        }
    }

}