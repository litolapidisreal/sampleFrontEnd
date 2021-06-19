package com.example.sampleFrontEnd.controller;

import com.example.sampleFrontEnd.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class RegistrationController {
    private final UserLoginService userLoginService;

    public RegistrationController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }
}
