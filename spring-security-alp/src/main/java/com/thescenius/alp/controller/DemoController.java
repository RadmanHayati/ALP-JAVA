package com.thescenius.alp.controller;


import com.thescenius.alp.entity.User;
import com.thescenius.alp.service.user.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/demo-controller")
@RequiredArgsConstructor
public class DemoController {

    private final AuthenticationService service;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        User user = service.getUserWithAuthorities();
        String object = user.getEmail();
        return ResponseEntity.ok("Hello from secured endpoint " + object);
        // Access properties of object
    }

}