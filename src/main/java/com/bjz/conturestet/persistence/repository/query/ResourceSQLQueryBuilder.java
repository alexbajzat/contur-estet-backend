package com.bjz.conturestet.persistence.repository.query;

import com.bjz.conturestet.exception.InvalidArgumentException;
import com.bjz.conturestet.persistence.repository.constants.CategorySQLConstants;
import com.bjz.conturestet.persistence.repository.constants.ResourceSQLConstants;
import com.bjz.conturestet.persistence.repository.constants.SQLConstants;
import com.bjz.conturestet.service.request.CreateCategoryRequest;
import com.bjz.conturestet.service.request.CreateResourceRequest;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 10/4/2018.
 */
public class ResourceSQLQueryBuilder {
    public static SQLQuery buildInsertQuery(CreateResourceRequest request) {
        String insertQuery = SQLConstants.buildInsertStatement(
                ResourceSQLConstants.TABLE_NAME,
                ResourceSQLConstants.NAME_FIELD,
                ResourceSQLConstants.EXTENSION_FIELD
        );

        SQLQueryBuilder builder = Optional.of(request)
                .map(r -> SQLQuery.builder()
                        .setQuery(insertQuery)
                        .addNamedParam(ResourceSQLConstants.NAME_FIELD, r.getName())
                        .addNamedParam(ResourceSQLConstants.EXTENSION_FIELD, r.getType().getExtension())
                )
                .orElseThrow(() -> new InvalidArgumentException("No insert value present"));

        return builder.build();
    }

    public static SQLQuery buildSelectByField(String fieldName, Object fieldValue) {
        validateField(fieldName);

        return SQLQuery.builder()
                .setQuery(buildSelect() + SQLConstants.buildWhere(fieldName, fieldValue))
                .addNamedParam(fieldName, fieldValue)
                .build();
    }

    public static SQLQuery buildDeleteByField(String fieldName, Object fieldValue) {
        validateField(fieldName);

        return SQLQuery.builder()
                .setQuery(SQLConstants.buildDelete(ResourceSQLConstants.TABLE_NAME)
                        + SQLConstants.buildWhere(fieldName, fieldValue))
                .addNamedParam(fieldName, fieldValue)
                .build();

    }

    public static SQLQuery buildSelectAllStatement() {
        return SQLQuery.builder()
                .setQuery(buildSelect())
                .build();
    }

    private static String buildSelect() {
        return SQLConstants.buildSelectStatement(
                ResourceSQLConstants.TABLE_NAME,
                ResourceSQLConstants.ID_FIELD,
                ResourceSQLConstants.NAME_FIELD,
                ResourceSQLConstants.EXTENSION_FIELD,
                ResourceSQLConstants.CREATED_ON_FIELD,
                ResourceSQLConstants.UPDATED_ON_FIELD
        );
    }

    private static void validateField(String fieldName) {
        Stream.of(ResourceSQLConstants.ALL_FIELDS)
                .filter(field -> field.equals(fieldName))
                .findFirst()
                .orElseThrow(() -> new InvalidArgumentException(String.format("Request field {%s} is not in the fields list", fieldName)));
    }
}
