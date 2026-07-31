package com.udemy.erp_lite.exceptions;

public class MyBusinessException extends RuntimeException {

    public MyBusinessException(String message) {
        super(message);
    }
}