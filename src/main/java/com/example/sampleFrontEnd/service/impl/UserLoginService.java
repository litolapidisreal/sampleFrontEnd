package com.example.sampleFrontEnd.service.impl;

import com.example.sampleFrontEnd.dao.UserLoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService implements UserDetailsService {

    private final UserLoginDao userLoginDao;

    @Autowired
    public UserLoginService(@Qualifier("fake") UserLoginDao userLoginDao) {
        this.userLoginDao = userLoginDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userLoginDao.selectUserLoginByUsername(username)
                .orElseThrow(() ->new UsernameNotFoundException(username));
    }
}
