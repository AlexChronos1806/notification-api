package com.java.challenge.notificationapi.domain.notification.validation;

import com.java.challenge.notificationapi.domain.notification.CategoryType;
import com.java.challenge.notificationapi.domain.notification.dto.RequestDTO;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CategoryRequestValidator implements RequestValidator {
    @Override
    public void validate(RequestDTO requestDTO) {
        final String category = requestDTO.getCategory();

        if (Arrays.stream(CategoryType.values()).noneMatch(categoryEnum -> categoryEnum.name().equalsIgnoreCase(category))) {
            throw new ValidationException("Invalid category!");
        }
    }
}
