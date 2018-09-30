package com.bjz.conturestet.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public class PasswordUtils {
    private static final String SALT = BCrypt.gensalt();

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, SALT);
    }

    public static boolean passwordsMatch(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}
