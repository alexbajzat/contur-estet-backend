package com.bjz.conturestet.security;

import java.util.Objects;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public class AuthenticatedUser {
    private Integer userID;

    public AuthenticatedUser(Integer userID) {
        Objects.requireNonNull(userID);
        this.userID = userID;
    }

    public Integer getUserID() {
        return userID;
    }
}
