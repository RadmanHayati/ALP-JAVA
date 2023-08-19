package com.thescenius.alp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {


    @GetMapping("/hello")
    public String hello() {
        return "Hello Welcome To Alp!!";
    }
}
