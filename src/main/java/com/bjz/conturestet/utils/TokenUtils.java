package com.bjz.conturestet.utils;

import com.bjz.conturestet.exception.InvalidArgumentException;
import com.bjz.conturestet.persistence.model.Account;
import io.jsonwebtoken.*;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public class TokenUtils {

    /***
     *
     * @param token value from the Authorization header
     * @param secret secret key used for jwt signing
     * @return the validated JWT
     */
    public static Jws<Claims> validateToken(@NotNull String token, @NotNull String secret) {
        Objects.requireNonNull(token);
        Objects.requireNonNull(secret);

        if (!token.startsWith("Bearer ")) {
            throw new InvalidArgumentException("Token is incosistent");
        }
        String jws = token.substring(7);

        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(jws);
    }

    public static String generateToken(Account account, String secret) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, secret)
                .claim("acc_type", account.getAccountType().name())
                .setSubject(account.getId().toString())
                .compact();
    }
}
