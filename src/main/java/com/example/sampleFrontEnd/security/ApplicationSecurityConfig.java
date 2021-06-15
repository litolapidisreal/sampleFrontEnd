package com.example.sampleFrontEnd.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static com.example.sampleFrontEnd.security.PermissionEnum.*;
import static com.example.sampleFrontEnd.security.UserEnum.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * FOR WEB SECURITY: Basic Authentication
     * Needs to login to pass request via "Header"
     * DOWNSIDE: No Logout scheme
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //CSRF - gives you ability to access PUT POST DELETE functions
        http
                .csrf().disable() //-> TOKEN Creation
                //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and() // TODO: Creates a token that cannot be taken by FE

                .authorizeRequests()
                //ANT MATCHERS FOR MAKING SOME PAGES TO BE ABLE TO  LOAD WITHOUT LOGGIN IN
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                /**
                 * Role based AUTHENTICATION
                 * NOTE: WITHOUT HttpMethod -> Assumed as "get"
                 */
                .antMatchers("/api/products", "/api/products/*").hasAnyRole(STUDENT.name())
                .antMatchers("/api/sampler/*", "/api/products", "/api/products/*").hasAnyRole(ADMIN.name())
                /**
                 * Permission Based Authentication
                 */
                .antMatchers(HttpMethod.POST,"/api/transactions**").hasAuthority(TRANSACTION_WRITE.getPermission())
                .antMatchers(HttpMethod.DELETE,"/api/transactions").hasAuthority(TRANSACTION_DELETE.getPermission())
                .antMatchers(HttpMethod.GET, "/api/transactionsSampler/**").hasAuthority(TRANSACTION_UPDATE.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }


    /**For DB Based Encryption for Login
     *NOTE: Needs seperate passwordEncode
     * password encryption
     */

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails userDetails = User.builder()
                .username("DONDON")
                .password(passwordEncoder.encode("MONTALIBANO"))
//                .roles(STUDENT.name())
                .authorities(STUDENT.getGrantedAuthoritySet())
                .build();
        UserDetails adminUser = User.builder()
                .username("linda")
                .password(passwordEncoder.encode("linda"))
                //.roles(ADMIN.name())
                .authorities(ADMIN.getGrantedAuthoritySet())
                .build();
        /**
         * User with Permission
         */
        UserDetails byRoleUser = User.builder()
                .username("anitalinda")
                .password(passwordEncoder.encode("linda"))
//                .roles(CLERK.name())
                .authorities(CLERK.getGrantedAuthoritySet())
                .build();
        /**Uses memory from Local Run Memory
         * Other types for UserDetailService
         * 1. CachingUserDetailsService
         * 2. InMemoryUserDetailsManager
         * 3. JdbcDaoImpl
         * 4. JdbcUserDetailsManager
         * 5. ReactiveUserDetailsServiceAdapter in WithUserDetailsSecurityContextFactory
         * 6. UserDetailsManager
         * 7. UserDetailsServiceDelegator in WebSecurityConfigurerAdapter
         */
        return new InMemoryUserDetailsManager(userDetails, adminUser, byRoleUser);
    }
}
