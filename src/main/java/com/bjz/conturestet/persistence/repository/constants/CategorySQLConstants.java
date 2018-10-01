package com.bjz.conturestet.persistence.repository.constants;

/**
 * Brought to life by bjz on 10/1/2018.
 */
public class CategorySQLConstants {
    public static final String TABLE_NAME = "category";

    public static final String ID_FIELD = "id";
    public static final String NAME_FIELD = "name";
    public static final String RESOURCE_ID_FIELD = "resource_id";
    public static final String CREATED_ON = "created_on";
    public static final String UPDATED_ON = "updated_on";

    public static final String[] ALL_FIELDS = {
            ID_FIELD,
            NAME_FIELD,
            RESOURCE_ID_FIELD,
            CREATED_ON,
            UPDATED_ON
    };
}
