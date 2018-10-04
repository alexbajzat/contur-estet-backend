package com.bjz.conturestet.persistence.repository.api;

import com.bjz.conturestet.persistence.model.Account;
import com.bjz.conturestet.service.request.CreateAccountRequest;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Brought to life by bjz on 9/29/2018.
 */
public interface AccountRepository {
    CompletableFuture<Account> createAccount(CreateAccountRequest request);

    CompletableFuture<Void> deleteAccount(Integer id);

    CompletableFuture<Account> findAccount(Integer id);

    CompletableFuture<Optional<Account>> findAccount(String email);
}
