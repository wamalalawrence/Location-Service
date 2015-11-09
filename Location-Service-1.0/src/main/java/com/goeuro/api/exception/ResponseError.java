package com.goeuro.api.exception;

import java.io.Serializable;

/**
 * Created by wamalalawrence on 15/11/04.
 * ResponseError model object
 */

public class ResponseError implements Serializable{

    private String message;

    public ResponseError(String message, String... args) {
        this.message = String.format(message, args);
    }

    public ResponseError(Exception e) {
        this.message = e.getMessage();
    }

    public String getMessage() {
        return this.message;
    }
}
