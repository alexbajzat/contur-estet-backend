package com.bjz.conturestet.persistence.repository.constants;

import java.util.Collection;
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
    public static final String DELETE = " DELETE ";
    public static final String JOIN = " JOIN ";
    public static final String LEFT_JOIN = " LEFT JOIN ";
    public static final String RIGHT_JOIN = " RIGHT JOIN ";
    public static final String ON = " ON ";
    public static final String OPEN_PARENTHESIS = " ( ";
    public static final String CLOSED_PARENTHESIS = " ) ";


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

    public static String buildEqualStatement(String field, String field2) {
        return String.format("%s = %s", field, field2);
    }

    public static String buildEqualWithParamStatement(String field, String namedParam) {
        return String.format("%s = :%s", field, namedParam);
    }

    public static String buildFieldInStatement(String field, String namedListParam) {
        return String.format("%s IN (:%s)", field, namedListParam);
    }

    public static String buildWhere(String fieldName, Object fieldValue) {
        String conditionStatement = "";
        //if field is scalar ( = ) or if field is vector ( IN )
        if (fieldValue instanceof Collection) {
            conditionStatement = SQLConstants.buildFieldInStatement(fieldName, fieldName);
        } else {
            conditionStatement = SQLConstants.buildEqualWithParamStatement(fieldName, fieldName);
        }

        return String.format(
                " %s %s ",
                SQLConstants.WHERE,
                conditionStatement);
    }

    public static String buildDelete(String tableName) {
        return String.format(
                "%s %s %s",
                SQLConstants.DELETE,
                SQLConstants.FROM,
                tableName);
    }

    public static String buildJoin(String table1, String table2, String field1, String field2) {
        return table1 + JOIN + table2 + ON + buildEqualStatement(field1, field2);
    }

    public static String buildJoin(String table2, String field1, String field2) {
        return JOIN + table2 + ON + buildEqualStatement(field1, field2);
    }
}
