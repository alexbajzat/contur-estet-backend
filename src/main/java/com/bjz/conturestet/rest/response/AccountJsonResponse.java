package com.bjz.conturestet.rest.response;

import com.bjz.conturestet.persistence.model.Account;

import java.time.LocalDateTime;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public class AccountJsonResponse {
    private final String email;
    private final Account.AccountType accountType;
    private final LocalDateTime createdOn;
    private final LocalDateTime updatedOn;

    AccountJsonResponse(String email, Account.AccountType accountType, LocalDateTime createdOn, LocalDateTime updatedOn) {
        this.email = email;
        this.accountType = accountType;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public static AccountJsonResponseBuilder builder() {
        return new AccountJsonResponseBuilder();
    }

    public String getEmail() {
        return email;
    }

    public Account.AccountType getAccountType() {
        return accountType;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }
}
