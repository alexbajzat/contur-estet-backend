package com.bjz.conturestet.persistence.request;

import com.bjz.conturestet.persistence.model.Account;

import java.util.Objects;

/**
 * Brought to life by bjz on 9/29/2018.
 */
public class CreateAccountRequestBuilder {
    private String email;
    private String password;
    private Account.AccountType accountType;

    public CreateAccountRequest build() {
        Objects.requireNonNull(email);
        Objects.requireNonNull(password);
        Objects.requireNonNull(accountType);

        return new CreateAccountRequest(email, password, accountType);
    }

    public CreateAccountRequestBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public CreateAccountRequestBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public CreateAccountRequestBuilder setAccountType(Account.AccountType accountType) {
        this.accountType = accountType;
        return this;
    }
}
