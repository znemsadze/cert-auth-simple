package com.magti.x509.rest.resources;

/**
 * Created by zviad on 5/20/18.
 * Simple result class
 */
public class ResultObj {
    private Long errorCode;

    private String message;

    public Long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Long errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public ResultObj(Long errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ResultObj() {
    }

    @Override
    public String toString() {
        return "ResultObj{" +
                "errorCode=" + errorCode +
                ", message='" + message + '\'' +
                '}';
    }
}
