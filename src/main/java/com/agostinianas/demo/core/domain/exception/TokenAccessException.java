package com.agostinianas.demo.core.domain.exception;

public class TokenAccessException extends RuntimeException {

    public TokenAccessException(String message, Throwable e) {
        super(message, e);
    }
}
