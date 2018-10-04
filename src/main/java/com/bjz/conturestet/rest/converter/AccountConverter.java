package com.bjz.conturestet.rest.converter;

import com.bjz.conturestet.persistence.model.Account;
import com.bjz.conturestet.service.request.CreateAccountRequest;
import com.bjz.conturestet.rest.request.CreateAccountJsonRequest;
import com.bjz.conturestet.rest.response.AccountJsonResponse;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public class AccountConverter {
    public static CreateAccountRequest mapFromJSON(CreateAccountJsonRequest request) {
        return CreateAccountRequest.builder()
                .setEmail(request.getEmail())
                .setPassword(request.getPassword())
                .setAccountType(request.getAccountType())
                .build();
    }

    public static AccountJsonResponse mapToJSON(Account account) {
        return AccountJsonResponse.builder()
                .setEmail(account.getEmail())
                .setAccountType(account.getAccountType())
                .setCreatedOn(account.getCreatedOn())
                .setUpdatedOn(account.getUpdatedOn())
                .build();
    }

}
