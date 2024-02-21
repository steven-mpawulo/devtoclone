package com.example.devtoclone.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class NoArticleFoundException extends ResponseStatusException {
    public NoArticleFoundException(HttpStatusCode code, String message) {
        super(code, message);
    }
}
