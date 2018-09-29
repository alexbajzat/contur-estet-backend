package com.bjz.conturestet.persistence.repository.query;

import com.bjz.conturestet.exception.InvalidArgumentException;
import com.bjz.conturestet.persistence.repository.constants.AccountSQLConstants;
import com.bjz.conturestet.persistence.repository.constants.SQLConstants;
import com.bjz.conturestet.persistence.request.CreateAccountRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
                        .addNamedParam(AccountSQLConstants.ACCOUNT_TYPE, r.getAccountType().name()))
                .orElseThrow(() -> new InvalidArgumentException("No insert value present"));

        return builder.build();
    }

    public static SQLQuery buildSelectByID(Integer id) {
        String selectStatement = SQLConstants.buildSelectStatement(
                AccountSQLConstants.TABLE_NAME,
                AccountSQLConstants.ID_FIELD,
                AccountSQLConstants.EMAIL_FIELD,
                AccountSQLConstants.PASSWORD_FIELD,
                AccountSQLConstants.ACCOUNT_TYPE,
                AccountSQLConstants.CREATED_ON,
                AccountSQLConstants.UPDATED_ON
        );

        String where = String.format(
                " %s %s = :%s ",
                SQLConstants.WHERE,
                AccountSQLConstants.ID_FIELD,
                AccountSQLConstants.ID_FIELD);
        return SQLQuery.builder()
                .setQuery(selectStatement + where)
                .addNamedParam(AccountSQLConstants.ID_FIELD, id)
                .build();
    }


}
