package com.bjz.conturestet.persistence.repository.constants;

/**
 * Brought to life by bjz on 9/29/2018.
 */
public class AccountSQLConstants {
    public final static String TABLE_NAME = "account";

    public final static String ID_FIELD = TABLE_NAME + ".id";
    public final static String EMAIL_FIELD = TABLE_NAME + ".email";
    public final static String PASSWORD_FIELD = TABLE_NAME + ".password";
    public final static String ACCOUNT_TYPE = TABLE_NAME + ".account_type";
    public static final String CREATED_ON_FIELD = TABLE_NAME + ".created_on";
    public static final String UPDATED_ON_FIELD = TABLE_NAME + ".updated_on";

    public final static String[] ALL_FIELDS = {
            ID_FIELD,
            EMAIL_FIELD,
            PASSWORD_FIELD,
            ACCOUNT_TYPE,
            CREATED_ON_FIELD,
            UPDATED_ON_FIELD
    };

}
