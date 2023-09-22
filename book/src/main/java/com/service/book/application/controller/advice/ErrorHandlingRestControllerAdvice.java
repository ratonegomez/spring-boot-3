package com.service.book.application.controller.advice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.net.URI;

@RestControllerAdvice
public class ErrorHandlingRestControllerAdvice {

    @ExceptionHandler
    ProblemDetail problemDetail(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {
        var pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST.value());
        pd.setType(URI.create("http://localhost:8080/api/books/errors/not-found"));
        pd.setDetail(ex.getLocalizedMessage());
        return pd;
    }
}
