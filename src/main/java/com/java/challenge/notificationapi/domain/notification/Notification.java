package com.java.challenge.notificationapi.domain.notification;

import com.java.challenge.notificationapi.domain.notification.dto.NotificationDTO;

public interface Notification {

    NotificationDTO createNotification(CategoryType categoryType, String message);

    NotificationType getNotificationType();
}
