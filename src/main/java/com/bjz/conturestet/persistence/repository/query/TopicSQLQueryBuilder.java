package com.bjz.conturestet.persistence.repository.query;

import com.bjz.conturestet.exception.InvalidArgumentException;
import com.bjz.conturestet.persistence.repository.constants.CategorySQLConstants;
import com.bjz.conturestet.persistence.repository.constants.SQLConstants;
import com.bjz.conturestet.persistence.repository.constants.TopicSQLConstants;
import com.bjz.conturestet.service.request.CreateTopicRequest;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 10/2/2018.
 */
public class TopicSQLQueryBuilder {
    public static SQLQuery buildInsertQuery(CreateTopicRequest request) {
        String insertQuery = SQLConstants.buildInsertStatement(
                TopicSQLConstants.TABLE_NAME,
                TopicSQLConstants.NAME_FIELD,
                TopicSQLConstants.CATEGORY_ID_FIELD
        );

        SQLQueryBuilder builder = Optional.of(request)
                .map(r -> SQLQuery.builder()
                        .setQuery(insertQuery)
                        .addNamedParam(TopicSQLConstants.NAME_FIELD, r.getName())
                        .addNamedParam(TopicSQLConstants.CATEGORY_ID_FIELD, r.getCategoryId()))
                .orElseThrow(() -> new InvalidArgumentException("No insert value present"));

        return builder.build();
    }

    public static SQLQuery buildSelectByField(String fieldName, Object fieldValue) {
        validateField(fieldName);

        return SQLQuery.builder()
                .setQuery(buildSelectAll() + SQLConstants.buildWhere(fieldName, fieldValue))
                .addNamedParam(fieldName, fieldValue)
                .build();
    }

    public static SQLQuery buildSelectAllStatement() {
        return SQLQuery.builder()
                .setQuery(buildSelectAll())
                .build();
    }

    public static SQLQuery buildDeleteByField(String fieldName, Object fieldValue) {
        validateField(fieldName);


        String deleteQuery = String.format(
                "%s %s %s %s",
                SQLConstants.DELETE,
                SQLConstants.FROM,
                TopicSQLConstants.TABLE_NAME,
                SQLConstants.buildWhere(fieldName, fieldValue));

        return SQLQuery.builder()
                .setQuery(deleteQuery)
                .addNamedParam(fieldName, fieldValue)
                .build();
    }

    private static String buildSelectAll() {
        String fieldList = Stream.of(TopicSQLConstants.ALL_FIELDS, CategorySQLConstants.ALL_FIELDS)
                .flatMap(Stream::of)
                .collect(Collectors.joining(", "));

        return String.format(
                "%s %s %s %s %s %s %s %s",
                SQLConstants.SELECT,
                fieldList,
                SQLConstants.FROM,
                TopicSQLConstants.TABLE_NAME,
                SQLConstants.JOIN,
                CategorySQLConstants.TABLE_NAME,
                SQLConstants.ON,
                SQLConstants.buildEqualStatement(TopicSQLConstants.CATEGORY_ID_FIELD, CategorySQLConstants.ID_FIELD));

    }


    private static void validateField(String fieldName) {
        Stream.of(TopicSQLConstants.ALL_FIELDS)
                .filter(field -> field.equals(fieldName))
                .findFirst()
                .orElseThrow(() -> new InvalidArgumentException(String.format("Request field {%s} is not in the fields list", fieldName)));

    }
}
