package com.example.demo.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExceptionHandling extends RuntimeException {
    public ExceptionHandling(Long taskId) {
        super("Task not found with ID: " + taskId);
    }
}