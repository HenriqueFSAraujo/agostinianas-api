package com.agostinianas.demo.core.domain.exception;



public class MissingParameterException extends RuntimeException {

    public MissingParameterException(String message) {
        super(message);
    }
}
