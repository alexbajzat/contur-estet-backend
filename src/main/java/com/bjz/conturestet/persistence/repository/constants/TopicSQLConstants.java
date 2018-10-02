package com.bjz.conturestet.persistence.repository.constants;

/**
 * Brought to life by bjz on 10/2/2018.
 */
public class TopicSQLConstants {
    public static final String TABLE_NAME = "topic";

    public static final String ID_FIELD = TABLE_NAME + ".id";
    public static final String NAME_FIELD = TABLE_NAME + ".name";
    public static final String CATEGORY_ID_FIELD = TABLE_NAME + ".category_id";
    public static final String CREATED_ON_FIELD = TABLE_NAME + ".created_on";
    public static final String UPDATED_ON_FIELD = TABLE_NAME + ".updated_on";

    public final static String[] ALL_FIELDS = {
            ID_FIELD,
            NAME_FIELD,
            CATEGORY_ID_FIELD,
            CREATED_ON_FIELD,
            UPDATED_ON_FIELD,
    };


}
