package com.bjz.conturestet.persistence.repository;

import com.bjz.conturestet.persistence.model.Account;
import com.bjz.conturestet.persistence.repository.api.AccountRepository;
import com.bjz.conturestet.persistence.request.CreateAccountRequest;

import java.util.concurrent.CompletableFuture;

/**
 * Brought to life by bjz on 9/29/2018.
 */
public class AccountRepositorySQL implements AccountRepository {
    @Override
    public CompletableFuture<Account> createAccount(CreateAccountRequest request) {
        return null;
    }

    @Override
    public CompletableFuture<Void> deleteAccount(Integer id) {
        return null;
    }

    @Override
    public CompletableFuture<Account> findAccount(Integer id) {
        return null;
    }
}
