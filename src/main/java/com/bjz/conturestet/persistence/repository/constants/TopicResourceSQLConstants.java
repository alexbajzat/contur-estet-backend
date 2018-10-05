package com.bjz.conturestet.persistence.repository.constants;

/**
 * Brought to life by bjz on 10/6/2018.
 */
public class TopicResourceSQLConstants {
    public final static String TABLE_NAME = "topic_resource";

    public final static String ID_FIELD = "id";
    public final static String RESOURCE_ID_FIELD = "resource_id";
    public final static String TOPIC_ID_FIELD = "topic_id";
    public final static String CREATED_ON_FIELD = "created_on";
    public final static String UPDATED_ON_FIELD = "updated_on";

    public static final String[] ALL_FIELDS = {
            ID_FIELD,
            RESOURCE_ID_FIELD,
            TOPIC_ID_FIELD,
            CREATED_ON_FIELD,
            UPDATED_ON_FIELD
    };

}
