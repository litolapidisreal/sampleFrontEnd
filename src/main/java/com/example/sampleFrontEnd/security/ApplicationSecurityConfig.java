package com.example.sampleFrontEnd.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

//    private final PasswordEncoder passwordEncoder;
//
//    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

    /**
     * FOR WEB SECURITY: Basic Authentication
     * Needs to login to pass request via "Header"
     * DOWNSIDE: No Logout scheme
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests().anyRequest().permitAll();
        http.headers().frameOptions().disable();
    }


    /**For DB Based Encryption for Login
     *NOTE: Needs seperate passwordEncode
     * password encryption
     */

//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.builder()
//                .username("DONDON")
//                .password(passwordEncoder.encode("MONTALIBANO"))
//                .roles(STUDENT.name())
//                .build();
//        UserDetails adminUser = User.builder()
//                .username("linda")
//                .password(passwordEncoder.encode("linda"))
//                .roles(ADMIN.name())
//                .build();
//        UserDetails byRoleUser = User.builder()
//                .username("anitalinda")
//                .password(passwordEncoder.encode("linda"))
//                .roles(CLERK.name())
//                .build();
//        /**Uses memory from Local Run Memory
//         * Other types for UserDetailService
//         * 1. CachingUserDetailsService
//         * 2. InMemoryUserDetailsManager
//         * 3. JdbcDaoImpl
//         * 4. JdbcUserDetailsManager
//         * 5. ReactiveUserDetailsServiceAdapter in WithUserDetailsSecurityContextFactory
//         * 6. UserDetailsManager
//         * 7. UserDetailsServiceDelegator in WebSecurityConfigurerAdapter
//         */
//        return new InMemoryUserDetailsManager(userDetails, adminUser);
//    }
}
