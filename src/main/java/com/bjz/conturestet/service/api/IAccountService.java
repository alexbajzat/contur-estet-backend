package com.bjz.conturestet.service.api;

import com.bjz.conturestet.persistence.model.Account;
import com.bjz.conturestet.persistence.request.CreateAccountRequest;

import java.util.concurrent.CompletableFuture;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public interface IAccountService {
    CompletableFuture<Account> createAccount(CreateAccountRequest request);

    CompletableFuture<Void> deleteAccount(Integer id);
}
