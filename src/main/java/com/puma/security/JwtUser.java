package com.puma.security;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class JwtUser implements UserDetails {

    private final Long id;
    private final String username;
    private final String name;
    private final String password;
    private final String email;
    private final String phonePrincipal;
    private final String phoneAlternative;
    private final String education;
    private final String fullAddress;
    private final String cep;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean enabled;
    private final Date lastPasswordResetDate;
    private final String profession;


    public JwtUser(
            Long id,
            String username,
            String name,
            String email,
            String password,
            String phonePrincipal,
            String phoneAlternative,
            String education,
            String fullAddress,
            String cep,
            String profession,
            Collection<? extends GrantedAuthority> authorities,
            boolean enabled,
            Date lastPasswordResetDate) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phonePrincipal = phonePrincipal;
        this.phoneAlternative = phoneAlternative;
        this.education = education;
        this.fullAddress = fullAddress;
        this.cep = cep;
        this.profession = profession;
        this.authorities = authorities;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    @JsonIgnore
    public String getPhonePrincipal() {
        return phonePrincipal;
    }

    @JsonIgnore
    public String getPhoneAlternative() {
        return phoneAlternative;
    }

    @JsonIgnore
    public String getEducation() {
        return education;
    }

    @JsonIgnore
    public String getCep() {
        return cep;
    }

    @JsonIgnore
    public String getFullAddress() {
        return fullAddress;
    }

    @JsonIgnore
    public String getProfession() {
        return profession;
    }

}
