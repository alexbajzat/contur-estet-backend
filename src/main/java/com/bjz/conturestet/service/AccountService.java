package com.bjz.conturestet.service;

import com.bjz.conturestet.exception.RegisterException;
import com.bjz.conturestet.persistence.model.Account;
import com.bjz.conturestet.persistence.repository.api.AccountRepository;
import com.bjz.conturestet.persistence.request.CreateAccountRequest;
import com.bjz.conturestet.service.api.IAccountService;
import com.bjz.conturestet.service.transformer.CreateAccountTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * Brought to life by bjz on 9/30/2018.
 */
@Service
public class AccountService implements IAccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public CompletableFuture<Account> createAccount(CreateAccountRequest request) {
        CreateAccountTransformer transformer = new CreateAccountTransformer();

        //validate and transform data
        CreateAccountRequest transform = transformer.transform(request);

        return accountRepository.findAccount(transform.getEmail())
                .thenApply(account -> {
                    if (account.isPresent()) {
                        throw new RegisterException("An account for this email already exists");
                    }
                    return transform;
                }).thenCompose(accountRepository::createAccount);
    }

    @Override
    public CompletableFuture<Void> deleteAccount(Integer id) {
        Objects.requireNonNull(id);
        return accountRepository.deleteAccount(id);
    }

}
