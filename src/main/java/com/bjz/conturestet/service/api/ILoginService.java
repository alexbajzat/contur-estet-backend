package com.bjz.conturestet.service.api;

import com.bjz.conturestet.service.request.LoginAccountRequest;

import java.util.concurrent.CompletableFuture;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public interface ILoginService {
    CompletableFuture<String> doLogin(LoginAccountRequest request);
}
