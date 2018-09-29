package com.bjz.conturestet.rest.response;

import com.bjz.conturestet.persistence.model.Account;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public class AccountJsonResponseBuilder {
    private String email;
    private Account.AccountType accountType;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public AccountJsonResponse build() {
        Objects.requireNonNull(email);
        Objects.requireNonNull(accountType);
        Objects.requireNonNull(createdOn);
        Objects.requireNonNull(updatedOn);

        return new AccountJsonResponse(email, accountType, createdOn, updatedOn);
    }

    public AccountJsonResponseBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public AccountJsonResponseBuilder setAccountType(Account.AccountType accountType) {
        this.accountType = accountType;
        return this;
    }

    public AccountJsonResponseBuilder setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public AccountJsonResponseBuilder setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }
}
