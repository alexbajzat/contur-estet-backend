package com.bjz.conturestet.rest;

import com.bjz.conturestet.persistence.model.Account;
import com.bjz.conturestet.rest.converter.AccountConverter;
import com.bjz.conturestet.rest.request.CreateAccountJsonRequest;
import com.bjz.conturestet.rest.response.AccountJsonResponse;
import com.bjz.conturestet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Brought to life by bjz on 9/30/2018.
 */
@RestController
@RequestMapping("/api")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ResponseEntity<AccountJsonResponse> createAccount(
            @RequestBody CreateAccountJsonRequest request) {

        request.setAccountType(Account.AccountType.REGULAR);
        return accountService.createAccount(AccountConverter.mapFromJSON(request))
                .thenApply(AccountConverter::mapToJSON)
                .thenApply(response -> new ResponseEntity<>(response, HttpStatus.CREATED))
                .join();
    }
}
