package com.bjz.conturestet.security;

import com.bjz.conturestet.utils.TokenUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public class AuthenticationTokenProvider {
    @Value(value = "${jwt.secret}")
    private String secret;

    /***
     *
     * @param token authorization header
     * @return authentication based on the token data
     */
    public Authentication authenticate(String token) {
        Jws<Claims> claimsJws = TokenUtils.validateToken(token, secret);
        Integer userID = Integer.valueOf(claimsJws.getBody().getSubject());
        String accountType = claimsJws.getBody()
                .get("acc_type", String.class);


        Collection<SimpleGrantedAuthority> authorities = Stream.of(accountType)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new UsernamePasswordAuthenticationToken(new AuthenticatedUser(userID), "useless", authorities);
    }
}
