package com.example.devtoclone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class NoUserFoundException extends ResponseStatusException {
    public NoUserFoundException(HttpStatusCode code, String message) {
        super(code, message);
    }
}
