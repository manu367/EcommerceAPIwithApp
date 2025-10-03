package com.ecommerce.ecommerceapi_.exception;

import java.time.LocalDateTime;

public class PaymentDeclinedException extends RuntimeException{

    private String code;          // Unique error code (e.g. USER_NOT_FOUND, PAYMENT_FAILED)
    private String message;       // Human-readable message
    private String details;       // Extra details (optional, for debugging)
    private int status;           // HTTP status code (e.g. 404, 400, 500)
    private String path;          // API path where error occurred
    private LocalDateTime timestamp;

    public PaymentDeclinedException(String message){
        super(message);
    }

    public PaymentDeclinedException(String code, String message, String details, int status, String path, LocalDateTime timestamp) {
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

    @Override
    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public int getStatus() {
        return status;
    }

    public String getPath() {
        return path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
