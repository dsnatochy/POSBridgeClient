package com.poynt.posbridgeclient.model;

/**
 * Created by dennis on 3/7/17.
 */
public class Error {


    private int errorCode;
    private String errorName;
    private String description;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrorName() {
        return errorName;
    }
}

