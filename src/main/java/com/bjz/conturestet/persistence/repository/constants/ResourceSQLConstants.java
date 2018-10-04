package com.bjz.conturestet.persistence.repository.constants;

/**
 * Brought to life by bjz on 10/4/2018.
 */
public class ResourceSQLConstants {
    public final static String TABLE_NAME = "file_resource";

    public final static String ID_FIELD = TABLE_NAME + ".id";
    public final static String NAME_FIELD = TABLE_NAME + ".name";
    public final static String EXTENSION_FIELD = TABLE_NAME + ".extension";
    public final static String CREATED_ON_FIELD = TABLE_NAME + ".created_on";
    public final static String UPDATED_ON_FIELD = TABLE_NAME + ".updated_on";

    public final static String[] ALL_FIELDS = {
            ID_FIELD,
            NAME_FIELD,
            EXTENSION_FIELD,
            CREATED_ON_FIELD,
            UPDATED_ON_FIELD
    };
}
