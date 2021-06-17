package com.example.sampleFrontEnd.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserLogin implements UserDetails {
    private final Collection<? extends GrantedAuthority> grantedAuthories;
    private final String password;
    private final String username;
    private final Boolean isAccountNonExpired;
    private final Boolean isAccountNonLocked;
    private final Boolean isCredentialsNonExpired;
    private final Boolean isEnabled;

    public UserLogin(Collection<? extends GrantedAuthority> grantedAuthories,
                     String password, String username,
                     Boolean isAccountNonExpired,
                     Boolean isAccountNonLocked,
                     Boolean isCredentialsNonExpired,
                     Boolean isEnabled) {
        this.grantedAuthories = grantedAuthories;
        this.password = password;
        this.username = username;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }

    public UserLogin(UserDetails userDetails) {
        this.grantedAuthories = (Collection<? extends GrantedAuthority>) userDetails.getAuthorities();
        this.password = userDetails.getPassword();
        this.username = userDetails.getUsername();
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthories;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
