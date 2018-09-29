package com.bjz.conturestet.persistence.repository.query;

import com.bjz.conturestet.exception.InvalidArgumentException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Brought to life by bjz on 9/29/2018.
 */
public class SQLQueryBuilder {
    private String query;
    private List<Object> params;
    private MapSqlParameterSource namedParams;

    SQLQueryBuilder() {
        params = new ArrayList<>();
        namedParams = new MapSqlParameterSource();
    }

    public SQLQuery build() {
        Objects.requireNonNull(query);

        if (params.size() > 0 && namedParams.getValues().size() > 0) {
            throw new InvalidArgumentException("Only one type of params accepted");
        }

        if (StringUtils.countOccurrencesOf(query, "?") != params.size()) {
            throw new InvalidArgumentException("Number of params in query don't match with actual params");
        }
        return new SQLQuery(query, params.toArray(), namedParams);
    }

    public SQLQueryBuilder setQuery(String query) {
        this.query = query;
        return this;
    }

    public SQLQueryBuilder setParams(List<Object> params) {
        this.params = params;
        return this;
    }

    public SQLQueryBuilder addParam(Object param) {
        params.add(param);
        return this;
    }

    public SQLQueryBuilder addNamedParam(String field, Object value) {
        namedParams.addValue(field, value);
        return this;
    }
}
