package com.bjz.conturestet.security.filter;

import com.bjz.conturestet.exception.InvalidArgumentException;
import com.bjz.conturestet.security.AuthenticationTokenProvider;
import io.jsonwebtoken.JwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public class TokenFilter extends GenericFilterBean {
    private final AuthenticationTokenProvider tokenProvider;
    private final static Logger LOGGER = LoggerFactory.getLogger(TokenFilter.class);

    @Autowired
    public TokenFilter(AuthenticationTokenProvider tokenProvider) {
        Objects.requireNonNull(tokenProvider);
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String authorization = request.getHeader("Authorization");

        if (!StringUtils.isEmpty(authorization)) {
            try {
                Authentication authenticate = tokenProvider.authenticate(authorization);
                SecurityContextHolder.getContext().setAuthentication(authenticate);
            } catch (InvalidArgumentException | JwtException e) {
                LOGGER.warn(
                        String.format("Invalid token received from addrr:{%s}, host:{%s}",
                                request.getRemoteAddr(),
                                request.getRemoteHost()));
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
