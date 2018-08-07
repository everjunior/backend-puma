package com.puma.security;

import java.io.Serializable;

/**
 * Created by stephan on 20.03.16.
 */
public class  JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String cpf;
    private String password;

    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String cpf, String password) {
        this.setUsername(cpf);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.cpf;
    }

    public void setUsername(String username) {
        this.cpf = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
