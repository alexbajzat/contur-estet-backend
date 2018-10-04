package com.bjz.conturestet.service.api;

import com.bjz.conturestet.persistence.model.Account;
import com.bjz.conturestet.service.request.CreateAccountRequest;

import javax.validation.constraints.NotNull;
import java.util.concurrent.CompletableFuture;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public interface IAccountService {
    CompletableFuture<Account> createAccount(@NotNull CreateAccountRequest request);

    CompletableFuture<Void> deleteAccount(@NotNull Integer id);

    CompletableFuture<Account> findAccountByEmail(@NotNull String email);
}
