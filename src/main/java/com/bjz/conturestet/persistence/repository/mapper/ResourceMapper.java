package com.bjz.conturestet.persistence.repository.mapper;

import com.bjz.conturestet.persistence.model.Resource;
import com.bjz.conturestet.persistence.repository.constants.ResourceSQLConstants;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Brought to life by bjz on 10/4/2018.
 */
public class ResourceMapper implements RowMapper<Resource> {
    @Nullable
    @Override
    public Resource mapRow(ResultSet resultSet, int i) throws SQLException {
        return Resource.builder()
                .setId(resultSet.getInt(ResourceSQLConstants.ID_FIELD))
                .setName(resultSet.getString(ResourceSQLConstants.NAME_FIELD))
                .setExtension(Resource.Type.getByExtension(resultSet.getString(ResourceSQLConstants.EXTENSION_FIELD)))
                .setCreatedOn(resultSet.getTimestamp(ResourceSQLConstants.CREATED_ON_FIELD).toLocalDateTime())
                .setUpdatedOn(resultSet.getTimestamp(ResourceSQLConstants.UPDATED_ON_FIELD).toLocalDateTime())
                .build();
    }
}
