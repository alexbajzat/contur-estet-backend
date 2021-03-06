package com.bjz.conturestet.persistence.repository.query;

import com.bjz.conturestet.exception.InvalidArgumentException;
import com.bjz.conturestet.persistence.repository.constants.CategorySQLConstants;
import com.bjz.conturestet.persistence.repository.constants.SQLConstants;
import com.bjz.conturestet.service.request.CreateCategoryRequest;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 10/1/2018.
 */
public class CategorySQLQueryBuilder {

    public static SQLQuery buildInsertQuery(CreateCategoryRequest request) {
        String insertQuery = SQLConstants.buildInsertStatement(
                CategorySQLConstants.TABLE_NAME,
                CategorySQLConstants.NAME_FIELD
        );

        SQLQueryBuilder builder = Optional.of(request)
                .map(r -> SQLQuery.builder()
                        .setQuery(insertQuery)
                        .addNamedParam(CategorySQLConstants.NAME_FIELD, r.getName())
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
                .setQuery(SQLConstants.buildDelete(CategorySQLConstants.TABLE_NAME) + SQLConstants.buildWhere(fieldName, fieldValue))
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
                CategorySQLConstants.TABLE_NAME,
                CategorySQLConstants.ID_FIELD,
                CategorySQLConstants.NAME_FIELD,
                CategorySQLConstants.CREATED_ON_FIELD,
                CategorySQLConstants.UPDATED_ON_FIELD
        );
    }

    private static void validateField(String fieldName) {
        Stream.of(CategorySQLConstants.ALL_FIELDS)
                .filter(field -> field.equals(fieldName))
                .findFirst()
                .orElseThrow(() -> new InvalidArgumentException(String.format("Request field {%s} is not in the fields list", fieldName)));

    }
}
