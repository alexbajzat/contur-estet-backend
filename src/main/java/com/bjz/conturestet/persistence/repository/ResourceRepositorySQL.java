package com.bjz.conturestet.persistence.repository;

import com.bjz.conturestet.exception.NotFoundException;
import com.bjz.conturestet.exception.SQLException;
import com.bjz.conturestet.persistence.model.Resource;
import com.bjz.conturestet.persistence.repository.api.ResourceRepository;
import com.bjz.conturestet.persistence.repository.constants.ResourceSQLConstants;
import com.bjz.conturestet.persistence.repository.mapper.ResourceMapper;
import com.bjz.conturestet.persistence.repository.query.ResourceSQLQueryBuilder;
import com.bjz.conturestet.persistence.repository.query.SQLQuery;
import com.bjz.conturestet.service.request.CreateResourceRequest;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Brought to life by bjz on 10/4/2018.
 */
@Repository
public class ResourceRepositorySQL extends BaseRepository implements ResourceRepository {
    @Override
    public CompletableFuture<Resource> createResource(CreateResourceRequest resourceRequest) {
        return CompletableFuture.supplyAsync(() -> {
            SQLQuery insertQuery = ResourceSQLQueryBuilder.buildInsertQuery(resourceRequest);
            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedJdbcTemplate.update(insertQuery.getQuery(), insertQuery.getNamedParams(), keyHolder);
            return Optional.ofNullable(keyHolder.getKey())
                    .orElseThrow(() -> new SQLException("Can't find generated key {resource}"))
                    .intValue();
        }).thenCompose(this::findResource);
    }

    @Override
    public CompletableFuture<Resource> findResource(Integer id) {
        return CompletableFuture.supplyAsync(() -> {
            SQLQuery selectQuery = ResourceSQLQueryBuilder.buildSelectByField(ResourceSQLConstants.ID_FIELD, id);
            List<Resource> resources = namedJdbcTemplate.query(
                    selectQuery.getQuery(),
                    selectQuery.getNamedParams(),
                    new ResourceMapper());
            return resources.stream()
                    .findFirst()
                    .orElseThrow(() -> new NotFoundException(
                            String.format("Can't find resource for id %d", id)));
        });
    }
}
