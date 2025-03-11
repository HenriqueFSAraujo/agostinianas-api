package com.agostinianas.demo.core.domain.exception;

import lombok.Getter;

@Getter
public class ClientServiceException extends RuntimeException {

    public ClientServiceException(String message) {
        super(message);
    }

    public ClientServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
