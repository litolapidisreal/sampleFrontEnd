package com.example.sampleFrontEnd.security;

import com.example.sampleFrontEnd.service.impl.UserLoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.concurrent.TimeUnit;

import static com.example.sampleFrontEnd.security.PermissionEnum.*;
import static com.example.sampleFrontEnd.security.UserEnum.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserLoginService userLoginService;
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,
                                     UserLoginService userLoginService) {
        this.passwordEncoder = passwordEncoder;
        this.userLoginService = userLoginService;
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
                /**FORM BASED LOGIN AUTHENTICATION
                 *
                 */
                .formLogin()
                /**
                 * Setting a login page
                 */
                .loginPage("/login").permitAll()
                /**
                 * default first page after login
                 */
                .defaultSuccessUrl("/hello", true)
                /**
                 * FOR REMEMBER ME functionality
                 * TODO Upto two weeks
                 */
                .and().rememberMe()
        .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(32)).key("ANYVALUEISHERE")
        .and().logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("JSESSIONID","remember-me");
        ;

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
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userLoginService);
        return provider;
//    protected UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.builder()
//                .username("DONDON")
//                .password(passwordEncoder.encode("MONTALIBANO"))
//                .authorities(STUDENT.getGrantedAuthoritySet())
//                .build();
//        UserDetails adminUser = User.builder()
//                .username("linda")
//                .password(passwordEncoder.encode("linda"))
//                .authorities(ADMIN.getGrantedAuthoritySet())
//                .build();
//        /**
//         * User with Permission
//         */
//        UserDetails byRoleUser = User.builder()
//                .username("anitalinda")
//                .password(passwordEncoder.encode("linda"))
//                .authorities(CLERK.getGrantedAuthoritySet())
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
//        return new InMemoryUserDetailsManager(userDetails, adminUser, byRoleUser);
    }
}
