package com.mgr.spring.controller.message;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class SuccessMessage {
    private HttpStatus status;
    private LocalDateTime timestamp;
    private String message;

    public SuccessMessage(HttpStatus status,String message) {
        this.status = status;
        this.timestamp = LocalDateTime.now();
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }
}

