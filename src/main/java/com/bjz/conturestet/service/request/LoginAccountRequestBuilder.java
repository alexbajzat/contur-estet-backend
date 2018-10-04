package com.bjz.conturestet.service.request;

import java.util.Objects;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public class LoginAccountRequestBuilder {
    private String email;
    private String password;

    public LoginAccountRequest build() {
        Objects.requireNonNull(email);
        Objects.requireNonNull(password);

        return new LoginAccountRequest(email, password);
    }

    public LoginAccountRequestBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public LoginAccountRequestBuilder setPassword(String password) {
        this.password = password;
        return this;
    }
}
