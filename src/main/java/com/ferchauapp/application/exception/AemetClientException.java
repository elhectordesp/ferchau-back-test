package com.ferchauapp.application.exception;

public class AemetClientException extends RuntimeException {
    public AemetClientException(String message) {
        super(message);
    }

    public AemetClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
