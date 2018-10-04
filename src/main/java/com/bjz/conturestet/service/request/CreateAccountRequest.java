package com.bjz.conturestet.service.request;

import com.bjz.conturestet.persistence.model.Account;

/**
 * Brought to life by bjz on 9/29/2018.
 */
public class CreateAccountRequest {
    private final String email;
    private final String password;
    private final Account.AccountType accountType;

    CreateAccountRequest(String email, String password, Account.AccountType accountType) {
        this.email = email;
        this.password = password;
        this.accountType = accountType;
    }

    public static CreateAccountRequestBuilder builder() {
        return new CreateAccountRequestBuilder();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Account.AccountType getAccountType() {
        return accountType;
    }
}
