package com.bjz.conturestet.config;

import com.bjz.conturestet.persistence.model.Account;
import com.bjz.conturestet.service.request.CreateAccountRequest;
import com.bjz.conturestet.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Brought to life by bjz on 9/30/2018.
 */
@Component
public class PostConstructJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostConstructJob.class);
    private final AccountService accountService;

    @Value("${admin.email}")
    private String adminEmail;

    @Autowired
    public PostConstructJob(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostConstruct
    public void generateAdminAccount() {
        CreateAccountRequest admin = CreateAccountRequest.builder()
                .setEmail(adminEmail)
                .setPassword("parola123")
                .setAccountType(Account.AccountType.ADMIN)
                .build();

        accountService.createAccount(admin)
                .thenApply(account -> {
                    LOGGER.info(
                            String.format(
                                    "Generate admin account email:{%s}, pass: {%s}",
                                    admin.getEmail(),
                                    admin.getPassword()));
                    return account;
                });
    }

}
