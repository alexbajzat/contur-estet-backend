package com.bjz.conturestet.service.transformer;

import com.bjz.conturestet.exception.InvalidArgumentException;
import com.bjz.conturestet.persistence.request.CreateAccountRequest;
import com.bjz.conturestet.utils.CommonUtils;
import com.bjz.conturestet.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public class CreateAccountTransformer implements Transformer<CreateAccountRequest> {
    @Value(value = "${user.password.minSize}")
    private int minPasswordSize;

    @Override
    public CreateAccountRequest transform(@NonNull CreateAccountRequest target) {
        Objects.requireNonNull(target);
        List<String> errors = new ArrayList<>();

        if (!CommonUtils.isValidEmail(target.getEmail())) {
            errors.add("Invalid email");
        }
        if (!CommonUtils.isValidPassword(target.getPassword(), minPasswordSize)) {
            errors.add("Invalid password");
        }
        if (!errors.isEmpty()) {
            String message = errors.stream()
                    .collect(Collectors.joining(", "));
            throw new InvalidArgumentException(message);
        }

        return CreateAccountRequest.builder()
                .setAccountType(target.getAccountType())
                .setEmail(target.getEmail())
                .setPassword(PasswordUtils.hashPassword(target.getPassword()))
                .build();
    }
}
