package com.java.challenge.notificationapi.domain.notification.validation;

import com.java.challenge.notificationapi.domain.notification.dto.RequestDTO;

public interface RequestValidator {

    void validate(RequestDTO requestDTO);
}
