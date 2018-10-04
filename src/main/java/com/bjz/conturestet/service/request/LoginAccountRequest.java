package com.bjz.conturestet.service.request;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public class LoginAccountRequest {
    private final String email;
    private final String password;

    LoginAccountRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static LoginAccountRequestBuilder builder() {
        return new LoginAccountRequestBuilder();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
