* FORM BASED LOGIN AUTHENTICATION
        
        .formLogin()

* Setting a login page
    
        .loginPage("/login").permitAll()
    ######Note: "/login" naming is default url for login pages

* Setting default first page after login

        .defaultSuccessUrl("/hello", true)

* FOR REMEMBER ME functionality

        .and().rememberMe()
        .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(32)).key("ANYVALUEISHERE")
        
    ######Note: remember-me naming is default naming for remember-me objects        
    ######Note: tokenValidity tends to last for at least two weeks with remember-me cookies
    
* Addition of Logout functionality
        
        .and().logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("JSESSIONID","remember-me");**
    ######Note: POST "/logout" naming is default url for logout pages
