package com.java.challenge.notificationapi.infra;

import com.java.challenge.notificationapi.domain.category.CategoryNotFoundException;
import com.java.challenge.notificationapi.domain.notification.email.EmailException;
import com.java.challenge.notificationapi.domain.notification.validation.ValidationException;
import com.java.challenge.notificationapi.domain.user.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotificationErrorHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorDTO> handleValidationException(ValidationException ex, HttpServletRequest request) {
        ErrorDTO errorDTO = new ErrorDTO(request.getRequestURI(), System.currentTimeMillis(), ex.getMessage());
        return ResponseEntity.badRequest().body(errorDTO);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleCategoryNotFoundException(CategoryNotFoundException ex, HttpServletRequest request) {
        ErrorDTO errorDTO = new ErrorDTO(request.getRequestURI(), System.currentTimeMillis(), ex.getMessage());
        return ResponseEntity.unprocessableEntity().body(errorDTO);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleUserNotFoundException(UserNotFoundException ex, HttpServletRequest request) {
        ErrorDTO errorDTO = new ErrorDTO(request.getRequestURI(), System.currentTimeMillis(), ex.getMessage());
        return ResponseEntity.unprocessableEntity().body(errorDTO);
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<ErrorDTO> handleEmailException(EmailException ex, HttpServletRequest request) {
        ErrorDTO errorDTO = new ErrorDTO(request.getRequestURI(), System.currentTimeMillis(), ex.getMessage());
        return ResponseEntity.unprocessableEntity().body(errorDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleException(Exception ex, HttpServletRequest request) {
        ErrorDTO errorDTO = new ErrorDTO(request.getRequestURI(), System.currentTimeMillis(), ex.getMessage());
        return ResponseEntity.internalServerError().body(errorDTO);
    }
}
