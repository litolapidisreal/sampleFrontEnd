package com.example.sampleFrontEnd.service;

import com.example.sampleFrontEnd.models.User;
import com.example.sampleFrontEnd.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserLoginService implements UserDetailsService {


    private final String MESSAGE = "The username or password you've entered is incorrect";
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userValue = Optional.empty();
        if (username.contains("@")){
            userValue = userRepository.findByEmail(username);
        } else {
            userValue = userRepository.finadByUserName(username);
        }
        return userValue.orElseThrow(() -> new BadCredentialsException(MESSAGE));
    }
}
