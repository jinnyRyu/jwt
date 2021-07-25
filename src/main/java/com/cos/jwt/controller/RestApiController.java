package com.cos.jwt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// @CrossOrigin 인증이 필요한건 거부
@RestController
public class RestApiController {

    @GetMapping("/home")
    public String home(){

        return "home";
    }
    
}
