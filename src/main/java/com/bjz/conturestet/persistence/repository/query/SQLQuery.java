package com.bjz.conturestet.persistence.repository.query;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

/**
 * Brought to life by bjz on 9/29/2018.
 */
public class SQLQuery {
    private final String query;
    private final Object[] params;
    private final MapSqlParameterSource namedParams;

    SQLQuery(String query, Object[] params, MapSqlParameterSource namedParams) {
        this.query = query;
        this.params = params;
        this.namedParams = namedParams;
    }

    public static SQLQueryBuilder builder() {
        return new SQLQueryBuilder();
    }

    public String getQuery() {
        return query;
    }

    public Object[] getParams() {
        return params;
    }

    public MapSqlParameterSource getNamedParams() {
        return namedParams;
    }
}
