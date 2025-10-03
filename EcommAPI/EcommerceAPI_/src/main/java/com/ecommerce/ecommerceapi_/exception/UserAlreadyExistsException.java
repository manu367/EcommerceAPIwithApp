package com.ecommerce.ecommerceapi_.exception;

import java.time.LocalDateTime;

public class UserAlreadyExistsException extends RuntimeException{
    private String code;          // Unique error code (e.g. USER_NOT_FOUND, PAYMENT_FAILED)
    private String message;       // Human-readable message
    private String details;       // Extra details (optional, for debugging)
    private int status;           // HTTP status code (e.g. 404, 400, 500)
    private String path;          // API path where error occurred
    private LocalDateTime timestamp;

    public UserAlreadyExistsException(String code, String message, String details, int status, String path, LocalDateTime timestamp) {
        super(message);
        this.code = code;
        this.message = message;
        this.details = details;
        this.status = status;
        this.path = path;
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
