package com.github.dop89.exception;


import com.github.dop89.model.Error;

public class NeoApiException extends RuntimeException {

    public NeoApiException(Error error) {
        super(error.getMessage());
    }

}
