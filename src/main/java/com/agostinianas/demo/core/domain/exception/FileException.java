package com.agostinianas.demo.core.domain.exception;

public class FileException extends RuntimeException {

    public FileException(String message, Throwable e) {
        super(message, e);
    }

}
