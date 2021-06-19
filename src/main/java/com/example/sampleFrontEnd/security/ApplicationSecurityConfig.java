package com.example.sampleFrontEnd.security;

import com.example.sampleFrontEnd.service.UserLoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserLoginService userLoginService;

    public ApplicationSecurityConfig(BCryptPasswordEncoder passwordEncoder, UserLoginService userLoginService) {
        this.passwordEncoder = passwordEncoder;
        this.userLoginService = userLoginService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/register/signUp").permitAll()
                .anyRequest().authenticated().and().formLogin();
        //H2 Console Security Bypass Setting
        http.headers().frameOptions().sameOrigin()
                .cacheControl();;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }


/**For DB Based Encryption for Login
     *NOTE: Needs seperate passwordEncode
     * password encryption
     */

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider =
                new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(userLoginService);
        return daoAuthenticationProvider;
    }
}
