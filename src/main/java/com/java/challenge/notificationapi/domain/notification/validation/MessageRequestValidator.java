package com.java.challenge.notificationapi.domain.notification.validation;

import com.java.challenge.notificationapi.domain.notification.dto.RequestDTO;
import org.springframework.stereotype.Component;

@Component
public class MessageRequestValidator implements RequestValidator {
    @Override
    public void validate(RequestDTO requestDTO) {
        final String message = requestDTO.getMessage();

        if (message == null || message.isEmpty() || message.isBlank()) {
            throw new ValidationException("Invalid message!");
        }
    }
}
