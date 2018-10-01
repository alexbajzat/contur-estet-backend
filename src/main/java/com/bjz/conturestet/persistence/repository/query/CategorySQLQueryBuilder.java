package com.bjz.conturestet.persistence.repository.query;

import com.bjz.conturestet.exception.InvalidArgumentException;
import com.bjz.conturestet.persistence.repository.constants.CategorySQLConstants;
import com.bjz.conturestet.persistence.repository.constants.SQLConstants;
import com.bjz.conturestet.persistence.request.CreateCategoryRequest;

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
        String selectStatement = SQLConstants.buildSelectStatement(
                CategorySQLConstants.TABLE_NAME,
                CategorySQLConstants.ID_FIELD,
                CategorySQLConstants.NAME_FIELD,
                CategorySQLConstants.CREATED_ON,
                CategorySQLConstants.UPDATED_ON
        );

        String where = String.format(
                " %s %s = :%s ",
                SQLConstants.WHERE,
                fieldName,
                fieldName);
        return SQLQuery.builder()
                .setQuery(selectStatement + where)
                .addNamedParam(fieldName, fieldValue)
                .build();
    }

    public static SQLQuery buildDeleteByField(String fieldName, Object fieldValue) {
        validateField(fieldName);

        String deleteQuery = String.format(
                "%s %s %s %s %s = :%s",
                SQLConstants.DELETE,
                SQLConstants.FROM,
                CategorySQLConstants.TABLE_NAME,
                SQLConstants.WHERE,
                fieldName,
                fieldName);

        return SQLQuery.builder()
                .setQuery(deleteQuery)
                .addNamedParam(fieldName, fieldValue)
                .build();

    }

    private static void validateField(String fieldName) {
        Stream.of(CategorySQLConstants.ALL_FIELDS)
                .filter(field -> field.equals(fieldName))
                .findFirst()
                .orElseThrow(() -> new InvalidArgumentException(String.format("Request field {%s} is not in the fields list", fieldName)));

    }
}
