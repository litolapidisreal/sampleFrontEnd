package com.example.sampleFrontEnd.dao;

import com.example.sampleFrontEnd.models.UserLogin;

import java.util.Optional;

public interface UserLoginDao {

    Optional<UserLogin> selectUserLoginByUsername(String username);
}
