package com.ecommerce.ecommerceapi_.exception;

public class BaseException extends Exception {

    private final String code;     // Custom error code (e.g. "USR_404", "ORD_409")
    private final String details;  // Extra details about the error
    private final int status;      // HTTP status code
    private final String path;     // Request path (URI where error occurred)

    public BaseException(String code, String message, String details, int status, String path) {
        super(message); // Store message in RuntimeException
        this.code = code;
        this.details = details;
        this.status = status;
        this.path = path;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
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
}
