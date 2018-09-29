package com.bjz.conturestet.persistence.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Brought to life by bjz on 9/29/2018.
 */
public class AccountBuilder {
    private Integer id;
    private String email;
    private String password;
    private Account.AccountType accountType;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public Account build() {
        Objects.requireNonNull(id);
        Objects.requireNonNull(email);
        Objects.requireNonNull(password);
        Objects.requireNonNull(accountType);
        Objects.requireNonNull(createdOn);
        Objects.requireNonNull(updatedOn);

        return new Account(id, email, password, accountType, createdOn, updatedOn);
    }

    public AccountBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public AccountBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public AccountBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public AccountBuilder setAccountType(Account.AccountType accountType) {
        this.accountType = accountType;
        return this;
    }

    public AccountBuilder setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public AccountBuilder setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }
}
