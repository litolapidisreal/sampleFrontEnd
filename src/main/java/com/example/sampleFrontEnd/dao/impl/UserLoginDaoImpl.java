package com.example.sampleFrontEnd.dao.impl;

import com.example.sampleFrontEnd.dao.UserLoginDao;
import com.example.sampleFrontEnd.models.UserLogin;
import com.google.common.collect.Lists;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.sampleFrontEnd.security.UserEnum.*;

@Repository("fake")
public class UserLoginDaoImpl implements UserLoginDao {

    private final PasswordEncoder passwordEncoder;

    public UserLoginDaoImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<UserLogin> selectUserLoginByUsername(String username) {
        return getUserLogin().stream()
                .filter(userLogin -> username.equals(userLogin.getUsername()))
                .findFirst();
    }

    private List<UserLogin> getUserLogin (){
        List<UserLogin> applicationUser = Lists.newArrayList(
                new UserLogin(User.builder()
                        .username("DONDON")
                        .password(passwordEncoder.encode("MONTALIBANO"))
                        .authorities(STUDENT.getGrantedAuthoritySet())
                        .build()),
                new UserLogin(User.builder()
                        .username("linda")
                        .password(passwordEncoder.encode("linda"))
                        .authorities(ADMIN.getGrantedAuthoritySet())
                        .build()),
                new UserLogin(User.builder()
                        .username("anitalinda")
                        .password(passwordEncoder.encode("linda"))
                        .authorities(CLERK.getGrantedAuthoritySet())
                        .build())
                );
        return applicationUser;
    }
}
