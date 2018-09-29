package com.bjz.conturestet.persistence.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Brought to life by bjz on 9/29/2018.
 */
public class BaseRepository {
    @Autowired
    protected NamedParameterJdbcTemplate namedJdbcTemplate;
    @Autowired
    protected JdbcTemplate jdbcTemplate;
}
