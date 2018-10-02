package com.bjz.conturestet.persistence.repository.mapper;

import com.bjz.conturestet.persistence.model.Category;
import com.bjz.conturestet.persistence.model.Topic;
import com.bjz.conturestet.persistence.repository.constants.CategorySQLConstants;
import com.bjz.conturestet.persistence.repository.constants.SQLConstants;
import com.bjz.conturestet.persistence.repository.constants.TopicSQLConstants;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Brought to life by bjz on 10/2/2018.
 */
public class TopicMapper implements RowMapper<Topic> {

    @Nullable
    @Override
    public Topic mapRow(ResultSet resultSet, int i) throws SQLException {
        Category category = new CategoryMapper()
                .mapRow(resultSet, 0);

        return Topic.builder()
                .setId(resultSet.getInt(TopicSQLConstants.ID_FIELD))
                .setName(resultSet.getString(TopicSQLConstants.NAME_FIELD))
                .setCategory(category)
                .setCreatedOn(resultSet.getTimestamp(TopicSQLConstants.CREATED_ON_FIELD).toLocalDateTime())
                .setUpdatedOn(resultSet.getTimestamp(TopicSQLConstants.UPDATED_ON_FIELD).toLocalDateTime())
                .build();
    }
}
