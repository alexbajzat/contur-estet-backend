package com.bjz.conturestet.rest.converter;

import com.bjz.conturestet.persistence.request.LoginAccountRequest;
import com.bjz.conturestet.rest.request.LoginAccountJsonRequest;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public class LoginAccountConverter {

    public static LoginAccountRequest fromJson(LoginAccountJsonRequest jsonRequest) {
        return LoginAccountRequest.builder()
                .setEmail(jsonRequest.getEmail())
                .setPassword(jsonRequest.getPassword())
                .build();
    }
}
