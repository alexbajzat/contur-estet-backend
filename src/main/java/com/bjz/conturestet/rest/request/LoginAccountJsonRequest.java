package com.bjz.conturestet.rest.request;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public class LoginAccountJsonRequest {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public LoginAccountJsonRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginAccountJsonRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}
