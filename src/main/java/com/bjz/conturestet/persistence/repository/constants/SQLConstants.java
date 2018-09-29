package com.bjz.conturestet.persistence.repository.constants;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 9/29/2018.
 */
public class SQLConstants {
    public static final String SELECT = " SELECT ";
    public static final String FROM = " FROM ";
    public static final String WHERE = " WHERE ";
    public static final String INSERT = " INSERT INTO ";
    public static final String VALUES = " VALUES ";
    public static final String ALIAS = " AS ";

    public static String buildInsertStatement(String tableName, String... fields) {
        String fieldNames = Stream.of(fields)
                .collect(Collectors.joining(", "));
        String params = Stream.of(fields)
                .map(field -> String.format(":%s", field))
                .collect(Collectors.joining(","));

        return String.format(
                "%s %s(%s) %s (%s)",
                INSERT,
                tableName,
                fieldNames,
                VALUES,
                params
        );
    }

    public static String buildSelectStatement(String tableName, String... fields) {
        String selectHeader = Stream.of(fields)
                .collect(Collectors.joining(", "));
        return String.format(" %s %s %s %s ", SELECT, selectHeader, FROM, tableName);
    }
}
