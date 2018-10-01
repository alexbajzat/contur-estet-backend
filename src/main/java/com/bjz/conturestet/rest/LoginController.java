package com.bjz.conturestet.rest;

import com.bjz.conturestet.rest.converter.LoginAccountConverter;
import com.bjz.conturestet.rest.request.LoginAccountJsonRequest;
import com.bjz.conturestet.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.concurrent.CompletableFuture;

/**
 * Brought to life by bjz on 9/30/2018.
 */
@RestController
@RequestMapping(value = "/api")
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CompletableFuture<ResponseEntity<String>> login(@RequestBody LoginAccountJsonRequest request) {
        return loginService.doLogin(LoginAccountConverter.fromJson(request))
                .thenApply(token -> new ResponseEntity<>(token, HttpStatus.OK));
    }
}
