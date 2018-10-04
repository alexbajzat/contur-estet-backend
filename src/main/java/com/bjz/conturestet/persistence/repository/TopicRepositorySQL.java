package com.bjz.conturestet.persistence.repository;

import com.bjz.conturestet.exception.NotFoundException;
import com.bjz.conturestet.exception.SQLException;
import com.bjz.conturestet.persistence.model.Topic;
import com.bjz.conturestet.persistence.repository.api.TopicRepository;
import com.bjz.conturestet.persistence.repository.constants.TopicSQLConstants;
import com.bjz.conturestet.persistence.repository.mapper.TopicMapper;
import com.bjz.conturestet.persistence.repository.query.SQLQuery;
import com.bjz.conturestet.persistence.repository.query.TopicSQLQueryBuilder;
import com.bjz.conturestet.service.request.CreateTopicRequest;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 10/2/2018.
 */
@Repository
public class TopicRepositorySQL extends BaseRepository implements TopicRepository {
    @Override
    public CompletableFuture<Topic> findTopic(@NotNull Integer id) {
        return CompletableFuture.supplyAsync(() -> {
            SQLQuery selectQuery = TopicSQLQueryBuilder.buildSelectByField(TopicSQLConstants.ID_FIELD, id);
            List<Topic> topics = namedJdbcTemplate.query(selectQuery.getQuery(), selectQuery.getNamedParams(), new TopicMapper());

            return topics.stream()
                    .findFirst()
                    .orElseThrow(() -> new NotFoundException(String.format("Can't find topic for id {%s}", id)));
        });
    }

    @Override
    public CompletableFuture<Topic> createtopic(@NotNull CreateTopicRequest request) {
        return CompletableFuture.supplyAsync(() -> {
            SQLQuery insertQuery = TopicSQLQueryBuilder.buildInsertQuery(request);
            KeyHolder keyHolder = new GeneratedKeyHolder();
            namedJdbcTemplate.update(insertQuery.getQuery(), insertQuery.getNamedParams(), keyHolder);

            return Optional.ofNullable(keyHolder.getKey())
                    .orElseThrow(() -> new SQLException("Generated ID is not present {topic}"))
                    .intValue();
        }).thenCompose(this::findTopic);
    }

    @Override
    public CompletableFuture<Stream<Topic>> findTopics() {
        return CompletableFuture.supplyAsync(() -> {
            SQLQuery selectAllQuery = TopicSQLQueryBuilder.buildSelectAllStatement();

            return namedJdbcTemplate.query(selectAllQuery.getQuery(), new TopicMapper()).stream();
        });
    }

    @Override
    public CompletableFuture<Stream<Topic>> findTopics(List<Integer> ids) {
        return CompletableFuture.supplyAsync(() -> {
            SQLQuery selectQuery = TopicSQLQueryBuilder.buildSelectByField(TopicSQLConstants.ID_FIELD, ids);

            return namedJdbcTemplate.query(selectQuery.getQuery(), selectQuery.getNamedParams(), new TopicMapper())
                    .stream();
        });
    }

    @Override
    public CompletableFuture<Void> deleteTopic(@NotNull Integer id) {
        return CompletableFuture.runAsync(() -> {
            SQLQuery deleteQuery = TopicSQLQueryBuilder.buildDeleteByField(TopicSQLConstants.ID_FIELD, id);
            int update = namedJdbcTemplate.update(deleteQuery.getQuery(), deleteQuery.getNamedParams());
            if (update == 0) {
                throw new NotFoundException(String.format("Can't find topic for ID {%s}", id));
            }
        });
    }
}
