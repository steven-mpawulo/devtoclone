package com.example.devtoclone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class FailedToCreateArticleException extends ResponseStatusException {
    public FailedToCreateArticleException(HttpStatusCode code, String message) {
        super(code, message);
    }
}
