package com.nelson.flexisaf.exception;

public class GenericApiException extends RuntimeException{
    public GenericApiException() {
        super();
    }

    public GenericApiException(String message) {
        super(message);
    }

    public GenericApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenericApiException(Throwable cause) {
        super(cause);
    }
}
