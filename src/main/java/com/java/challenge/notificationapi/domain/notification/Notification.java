package com.java.challenge.notificationapi.domain.notification;

import com.java.challenge.notificationapi.domain.notification.dto.NotificationDTO;

public interface Notification {

    NotificationDTO send(Category category, String message);

    NotificationType getNotificationType();
}
