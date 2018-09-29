package com.bjz.conturestet.persistence.repository.mapper;

import com.bjz.conturestet.persistence.model.Account;
import com.bjz.conturestet.persistence.repository.constants.AccountSQLConstants;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public class AccountMapper implements RowMapper<Account> {
    @Nullable
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        return Account.builder()
                .setId(resultSet.getInt(AccountSQLConstants.ID_FIELD))
                .setAccountType(Account.AccountType.getByValue(resultSet.getInt(AccountSQLConstants.ACCOUNT_TYPE)))
                .setPassword(resultSet.getString(AccountSQLConstants.PASSWORD_FIELD))
                .setEmail(resultSet.getString(AccountSQLConstants.EMAIL_FIELD))
                .setCreatedOn(resultSet.getTimestamp(AccountSQLConstants.CREATED_ON).toLocalDateTime())
                .setUpdatedOn(resultSet.getTimestamp(AccountSQLConstants.UPDATED_ON).toLocalDateTime())
                .build();
    }
}
