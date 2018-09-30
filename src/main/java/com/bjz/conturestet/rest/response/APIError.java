package com.bjz.conturestet.rest.response;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public class APIError {
    private String message;
    private ErrorCode code;

    public String getMessage() {
        return message;
    }

    public APIError setMessage(String message) {
        this.message = message;
        return this;
    }

    public ErrorCode getCode() {
        return code;
    }

    public APIError setCode(ErrorCode code) {
        this.code = code;
        return this;
    }

    public enum ErrorCode {
        BAD_REGISTER(100), BAD_LOGIN(200), NOT_PERMITTED(300), NOT_FOUND(400);

        int code;

        ErrorCode(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}
