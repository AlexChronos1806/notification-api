package com.java.challenge.notificationapi.domain.notification.service;

import com.java.challenge.notificationapi.domain.notification.Notification;
import com.java.challenge.notificationapi.domain.notification.validation.RequestValidator;
import com.java.challenge.notificationapi.domain.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {

    @InjectMocks
    private NotificationService notificationService;

    @Mock
    private List<RequestValidator> validations;

    @Mock
    private List<Notification> notifications;

    @Mock
    private UserService userService;

    @Test
    void shouldReturnSuccess() {



    }
}