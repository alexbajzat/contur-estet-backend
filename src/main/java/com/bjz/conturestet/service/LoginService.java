package com.bjz.conturestet.service;

import com.bjz.conturestet.exception.LoginException;
import com.bjz.conturestet.service.request.LoginAccountRequest;
import com.bjz.conturestet.service.api.ILoginService;
import com.bjz.conturestet.utils.PasswordUtils;
import com.bjz.conturestet.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * Brought to life by bjz on 9/30/2018.
 */
@Service
public class LoginService implements ILoginService {
    private final AccountService accountService;
    @Value("${jwt.secret}")
    private String secret;

    @Autowired
    public LoginService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public CompletableFuture<String> doLogin(@NotNull LoginAccountRequest request) {
        Objects.requireNonNull(request);
        return accountService.findAccountByEmail(request.getEmail())
                .exceptionally(ex -> null)
                .thenApply(account -> {
                    if (!Objects.isNull(account) && PasswordUtils.passwordsMatch(request.getPassword(), account.getPassword())) {
                        return TokenUtils.generateToken(account, secret);
                    } else {
                        throw new LoginException("Invalid email or password");
                    }
                });
    }
}
