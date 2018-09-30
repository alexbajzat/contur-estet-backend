package com.bjz.conturestet.persistence.repository.constants;

/**
 * Brought to life by bjz on 9/29/2018.
 */
public class AccountSQLConstants extends BaseConstants {
    public final static String TABLE_NAME = "account";

    public final static String ID_FIELD = "id";
    public final static String EMAIL_FIELD = "email";
    public final static String PASSWORD_FIELD = "password";
    public final static String ACCOUNT_TYPE = "account_type";

    public final static String[] ALL_FIELDS = {
            ID_FIELD,
            EMAIL_FIELD,
            PASSWORD_FIELD,
            ACCOUNT_TYPE,
            CREATED_ON,
            UPDATED_ON
    };

}
