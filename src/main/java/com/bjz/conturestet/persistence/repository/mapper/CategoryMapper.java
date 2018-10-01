package com.bjz.conturestet.persistence.repository.mapper;

import com.bjz.conturestet.persistence.model.Category;
import com.bjz.conturestet.persistence.repository.constants.CategorySQLConstants;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Brought to life by bjz on 10/1/2018.
 */
public class CategoryMapper implements RowMapper<Category> {
    @Nullable
    @Override
    public Category mapRow(ResultSet resultSet, int i) throws SQLException {
        return Category.builder()
                .setId(resultSet.getInt(CategorySQLConstants.ID_FIELD))
                .setName(resultSet.getString(CategorySQLConstants.NAME_FIELD))
                .setCreatedOn(resultSet.getTimestamp(CategorySQLConstants.CREATED_ON).toLocalDateTime())
                .setUpdatedOn(resultSet.getTimestamp(CategorySQLConstants.UPDATED_ON).toLocalDateTime())
                .build();
    }
}
