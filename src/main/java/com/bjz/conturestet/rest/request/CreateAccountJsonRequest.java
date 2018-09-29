package com.bjz.conturestet.rest.request;

import com.bjz.conturestet.persistence.model.Account;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public class CreateAccountJsonRequest {
    private String email;
    private String password;
    private Account.AccountType accountType;

    public String getEmail() {
        return email;
    }

    public CreateAccountJsonRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CreateAccountJsonRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public Account.AccountType getAccountType() {
        return accountType;
    }

    public CreateAccountJsonRequest setAccountType(Account.AccountType accountType) {
        this.accountType = accountType;
        return this;
    }
}
