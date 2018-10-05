package com.bjz.conturestet.persistence.repository.query;

import com.bjz.conturestet.persistence.repository.constants.ResourceSQLConstants;
import com.bjz.conturestet.persistence.repository.constants.SQLConstants;
import com.bjz.conturestet.persistence.repository.constants.TopicResourceSQLConstants;
import com.bjz.conturestet.persistence.repository.constants.TopicSQLConstants;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Brought to life by bjz on 10/6/2018.
 */
public class TopicResourceSQLQueryBuilder {

    public static SQLQuery buildSelectByField(String fieldName, Object fieldValue) {
        return new SQLQueryBuilder()
                .setQuery(buildSelectAll() + SQLConstants.buildWhere(fieldName, fieldValue))
                .addNamedParam(fieldName, fieldValue)
                .build();
    }

    private static String buildSelectAll() {
        String fieldList = Stream.of(ResourceSQLConstants.ALL_FIELDS, TopicSQLConstants.ALL_FIELDS)
                .flatMap(Stream::of)
                .collect(Collectors.joining(", "));

        return String.format(
                "%s %s %s %s %s",
                SQLConstants.SELECT,
                fieldList,
                SQLConstants.FROM,
                SQLConstants.buildJoin(
                        ResourceSQLConstants.TABLE_NAME,
                        TopicResourceSQLConstants.TABLE_NAME,
                        ResourceSQLConstants.ID_FIELD,
                        TopicResourceSQLConstants.RESOURCE_ID_FIELD),
                SQLConstants.buildJoin(
                        TopicSQLConstants.TABLE_NAME,
                        TopicResourceSQLConstants.TOPIC_ID_FIELD,
                        TopicSQLConstants.ID_FIELD
                ));

    }
}
