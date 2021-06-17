* Basic Role and Authority Authentication setup in AuthenticationConfig
        
       
        .antMatchers("/sampleURL").permitAll()
        .antMatchers("/sampleURL").hasAnyRole("sampleRole") 
        .antMatchers(HttpMethod.{GET, POST, PUT, DELETE},"/sampleURL")
            .hasAuthority("samplePERMISSION")
       
   ######[NOTE]: ROLEs are read as ROLE_{sampleROLE}. This will play a role when you create a seperate setup a DB/ Local Memory for Users
   ######[NOTE]: Authorities are random string that can be used in tandem with a role to define what can be or what cannot be touched by user. 
   ######[NOTE]: "permitAll()" is used to bypass authentication for pages like signup or login
   ######[NOTE]: anyMatchers("/sampleURL") assumes HTTPMETHOD == GET

* Basic Role and Authority Authentication setup in Controller Subclass

        //At Security Config file
        @EnableGlobalMethodSecurity(prePostEnabled = true)
         ....
         //At Controller 
             @PreAuthorize("hasAuthority('sampleAuthority')")
             @PreAuthorize("hasAnyRole('ROLE_ADMIN')")

         


           