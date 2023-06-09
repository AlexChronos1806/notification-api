package com.java.challenge.notificationapi.infra;

import com.java.challenge.notificationapi.domain.notification.validation.ValidationException;
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
}
