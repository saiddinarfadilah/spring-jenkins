package com.spring.spring.controller;

import com.spring.spring.model.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/")
public class SayJenkinsController {

    @GetMapping(
            path = "/say",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Object say() {
        return RestResponse.builder()
                .statusCode(HttpStatus.OK.toString())
                .statusMessage("Hello, Jenkins")
                .build();
    }
}
