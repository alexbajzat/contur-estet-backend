package com.bjz.conturestet.utils;

import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public class CommonUtils {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\." +
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";

    public static boolean isValidEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return false;
        }
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        return pattern.matcher(email).matches();
    }

    public static boolean isValidPassword(String password, int minCharacterNumber) {
        return password.length() >= minCharacterNumber;
    }
}
