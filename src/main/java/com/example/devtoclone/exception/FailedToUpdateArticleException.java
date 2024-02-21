package com.example.devtoclone.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;


public class FailedToUpdateArticleException extends ResponseStatusException {
    public FailedToUpdateArticleException(HttpStatusCode code, String message) {
        super(code, message);
    }
}


