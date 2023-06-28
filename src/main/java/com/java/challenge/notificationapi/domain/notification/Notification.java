package com.java.challenge.notificationapi.domain.notification;

import com.java.challenge.notificationapi.domain.notification.dto.NotificationDTO;

public interface Notification {

    NotificationDTO send(CategoryType categoryType, String message);

    NotificationType getNotificationType();
}
