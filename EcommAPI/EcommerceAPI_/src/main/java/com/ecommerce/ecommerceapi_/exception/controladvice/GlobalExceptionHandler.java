package com.ecommerce.ecommerceapi_.exception.controladvice;

import com.ecommerce.ecommerceapi_.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 🔹 Generic handler (fallback)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorModel> handleGeneric(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ErrorModel("GEN-500",
                        ex.getMessage(),
                        "Unexpected error occurred",
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "N/A",
                        LocalDateTime.now()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorModel> handleUserNotFound(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorModel> handleUserAlreadyExists(UserAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorModel> handleBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(CartEmptyException.class)
    public ResponseEntity<ErrorModel> handleCartEmpty(CartEmptyException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(CartItemNotFoundException.class)
    public ResponseEntity<ErrorModel> handleCartItemNotFound(CartItemNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorModel> handleCategoryNotFound(CategoryNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(ExternalServiceException.class)
    public ResponseEntity<ErrorModel> handleExternalService(ExternalServiceException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(FIleNotFoundException.class)
    public ResponseEntity<ErrorModel> handleFileNotFound(FIleNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<ErrorModel> handleInternalServer(InternalServerException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorModel> handleInvalidCredentials(InvalidCredentialsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(InvalidOrderStateException.class)
    public ResponseEntity<ErrorModel> handleInvalidOrderState(InvalidOrderStateException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(OrderAlreadyCancelledException.class)
    public ResponseEntity<ErrorModel> handleOrderAlreadyCancelled(OrderAlreadyCancelledException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorModel> handleOrderNotFound(OrderNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(OutOfStockException.class)
    public ResponseEntity<ErrorModel> handleOutOfStock(OutOfStockException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(PaymentDeclinedException.class)
    public ResponseEntity<ErrorModel> handlePaymentDeclined(PaymentDeclinedException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(PaymentFailedException.class)
    public ResponseEntity<ErrorModel> handlePaymentFailed(PaymentFailedException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(PriceMismatchException.class)
    public ResponseEntity<ErrorModel> handlePriceMismatch(PriceMismatchException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorModel> handleProductNotFound(ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(QuantityExceedsStockException.class)
    public ResponseEntity<ErrorModel> handleQuantityExceedsStock(QuantityExceedsStockException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorModel> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorModel(
                        ex.getCode(),
                        ex.getMessage(),
                        ex.getDetails(),
                        ex.getStatus(),
                        ex.getPath(),
                        LocalDateTime.now()
                ));
    }
}
