package com.bjz.conturestet.persistence.repository;

import com.bjz.conturestet.exception.NotFoundException;
import com.bjz.conturestet.exception.SQLException;
import com.bjz.conturestet.persistence.model.Category;
import com.bjz.conturestet.persistence.repository.api.CategoryRepository;
import com.bjz.conturestet.persistence.repository.constants.CategorySQLConstants;
import com.bjz.conturestet.persistence.repository.mapper.CategoryMapper;
import com.bjz.conturestet.persistence.repository.query.CategorySQLQueryBuilder;
import com.bjz.conturestet.persistence.repository.query.SQLQuery;
import com.bjz.conturestet.persistence.request.CreateCategoryRequest;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Brought to life by bjz on 10/1/2018.
 */
@Repository
public class CategoryRepositorySQL extends BaseRepository implements CategoryRepository {
    @Override
    public CompletableFuture<Category> findCategory(@NotNull Integer id) {
        SQLQuery findQuery = CategorySQLQueryBuilder.buildSelectByField(CategorySQLConstants.ID_FIELD, id);

        return CompletableFuture.supplyAsync(() -> {
            List<Category> categories = namedJdbcTemplate.query(
                    findQuery.getQuery(),
                    findQuery.getNamedParams(),
                    new CategoryMapper());

            return categories.stream()
                    .findFirst()
                    .orElseThrow(() -> new NotFoundException(String.format("No category found for id:{%d}", id)));

        });
    }

    @Override
    public CompletableFuture<Category> createCategory(@NotNull CreateCategoryRequest request) {
        return CompletableFuture.supplyAsync(() -> {
            SQLQuery insertQuery = CategorySQLQueryBuilder.buildInsertQuery(request);

            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedJdbcTemplate.update(insertQuery.getQuery(), insertQuery.getNamedParams(), keyHolder);

            return Optional.ofNullable(keyHolder.getKey())
                    .orElseThrow(() -> new SQLException("Generated ID is not present {category}"))
                    .intValue();
        }).thenCompose(this::findCategory);
    }

    @Override
    public CompletableFuture<Void> deleteCategory(@NotNull Integer id) {
        return CompletableFuture.supplyAsync(() -> {
            SQLQuery deleteQuery = CategorySQLQueryBuilder.buildDeleteByField(CategorySQLConstants.ID_FIELD, id);
            int update = namedJdbcTemplate.update(deleteQuery.getQuery(), deleteQuery.getNamedParams());
            if (update == 0) {
                throw new NotFoundException(String.format("Category with id {%s} not found", id));
            }
            return null;
        });
    }
}
