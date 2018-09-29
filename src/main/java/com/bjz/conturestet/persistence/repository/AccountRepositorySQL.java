package com.bjz.conturestet.persistence.repository;

import com.bjz.conturestet.exception.InvalidArgumentException;
import com.bjz.conturestet.exception.NotFoundException;
import com.bjz.conturestet.exception.SQLException;
import com.bjz.conturestet.persistence.model.Account;
import com.bjz.conturestet.persistence.repository.api.AccountRepository;
import com.bjz.conturestet.persistence.repository.mapper.AccountMapper;
import com.bjz.conturestet.persistence.repository.query.AccountSQLQueryBuilder;
import com.bjz.conturestet.persistence.repository.query.SQLQuery;
import com.bjz.conturestet.persistence.request.CreateAccountRequest;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Brought to life by bjz on 9/29/2018.
 */

@Repository
public class AccountRepositorySQL extends BaseRepository implements AccountRepository {
    @Override
    public CompletableFuture<Account> createAccount(CreateAccountRequest request) {
        return CompletableFuture.supplyAsync(() -> {
            SQLQuery insertQuery = AccountSQLQueryBuilder.buildInsertQuery(request);
            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedJdbcTemplate.update(insertQuery.getQuery(), insertQuery.getNamedParams(), keyHolder);

            return Optional.ofNullable(keyHolder.getKey())
                    .orElseThrow(() -> new SQLException("Generated ID is not present"))
                    .intValue();

        }).thenCompose(this::findAccount);
    }

    @Override
    public CompletableFuture<Void> deleteAccount(Integer id) {
        return null;
    }

    @Override
    public CompletableFuture<Account> findAccount(Integer id) {
        return CompletableFuture.supplyAsync(() -> {
            SQLQuery findQuery = AccountSQLQueryBuilder.buildSelectByID(id);
            AccountMapper mapper = new AccountMapper();
            List<Account> accounts = namedJdbcTemplate.query(
                    findQuery.getQuery(),
                    findQuery.getNamedParams(),
                    mapper);

            if (accounts.isEmpty()) {
                throw new NotFoundException(String.format("No account found for id: %d", id));
            }
            return accounts.get(0);
        });
    }
}
