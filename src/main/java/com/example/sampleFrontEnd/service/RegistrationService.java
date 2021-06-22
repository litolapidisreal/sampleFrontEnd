package com.example.sampleFrontEnd.service;

import com.example.sampleFrontEnd.models.User;

public interface RegistrationService {
    Boolean register(User user);
    Boolean update(User user);
    Boolean delete(String userName);
}
