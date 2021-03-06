package com.bjz.conturestet.persistence.repository.query;

import com.bjz.conturestet.exception.InvalidArgumentException;
import com.bjz.conturestet.persistence.repository.constants.AccountSQLConstants;
import com.bjz.conturestet.persistence.repository.constants.SQLConstants;
import com.bjz.conturestet.service.request.CreateAccountRequest;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 9/29/2018.
 */
public class AccountSQLQueryBuilder {

    public static SQLQuery buildInsertQuery(CreateAccountRequest request) {
        String insertQuery = SQLConstants.buildInsertStatement(
                AccountSQLConstants.TABLE_NAME,
                AccountSQLConstants.EMAIL_FIELD,
                AccountSQLConstants.PASSWORD_FIELD,
                AccountSQLConstants.ACCOUNT_TYPE
        );

        SQLQueryBuilder builder = Optional.of(request)
                .map(r -> SQLQuery.builder()
                        .setQuery(insertQuery)
                        .addNamedParam(AccountSQLConstants.EMAIL_FIELD, r.getEmail())
                        .addNamedParam(AccountSQLConstants.PASSWORD_FIELD, r.getPassword())
                        .addNamedParam(AccountSQLConstants.ACCOUNT_TYPE, r.getAccountType().getValue()))
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
                .setQuery(SQLConstants.buildDelete(AccountSQLConstants.TABLE_NAME)
                        + SQLConstants.buildWhere(fieldName, fieldValue))
                .addNamedParam(fieldName, fieldValue)
                .build();

    }

    private static String buildSelect() {
        return SQLConstants.buildSelectStatement(
                AccountSQLConstants.TABLE_NAME,
                AccountSQLConstants.ID_FIELD,
                AccountSQLConstants.EMAIL_FIELD,
                AccountSQLConstants.PASSWORD_FIELD,
                AccountSQLConstants.ACCOUNT_TYPE,
                AccountSQLConstants.CREATED_ON_FIELD,
                AccountSQLConstants.UPDATED_ON_FIELD
        );

    }

    private static void validateField(String fieldName) {
        Stream.of(AccountSQLConstants.ALL_FIELDS)
                .filter(field -> field.equals(fieldName))
                .findFirst()
                .orElseThrow(() -> new InvalidArgumentException(String.format("Request field {%s} is not in the fields list", fieldName)));

    }


}
