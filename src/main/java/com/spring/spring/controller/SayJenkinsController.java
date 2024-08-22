package com.spring.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/")
public class SayJenkinsController {

    @GetMapping(path = "/say")
    public Object say() {
        return Map.of("message", "Hello, Jenkins");
    }
}
