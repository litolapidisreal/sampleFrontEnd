package com.example.sampleFrontEnd.controller;

import com.example.sampleFrontEnd.service.UserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
//@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class LoginController {
    private final UserLoginService userLoginService;
    private final AuthenticationManager authenticationManager;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public LoginController(final UserLoginService userLoginService,
                           final AuthenticationManager authenticationManager) {
        this.userLoginService = userLoginService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Map<String, String> authenticationRequest)
            throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.get("username"),
                            bCryptPasswordEncoder.encode(
                                    authenticationRequest.get("password"))));
        } catch (BadCredentialsException exception) {
            throw new Exception("Incorrect username or password", exception);
        }


//        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok("{}");

    }
}
