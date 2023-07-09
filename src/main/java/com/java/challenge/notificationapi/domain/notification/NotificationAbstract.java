package com.java.challenge.notificationapi.domain.notification;

import com.java.challenge.notificationapi.domain.notification.dto.NotificationDTO;

import java.time.LocalDateTime;

public abstract class NotificationAbstract implements Notification {

    @Override
    public NotificationDTO createNotification(CategoryType categoryType, String message) {
        NotificationDTO notificationDTO = new NotificationDTO.NotificationDTOBuilder()
                .message(message)
                .categoryType(categoryType)
                .notificationType(getNotificationType())
                .dateTime(LocalDateTime.now()).build();

        sendNotification(notificationDTO);

        return notificationDTO;
    }

    protected abstract void sendNotification(NotificationDTO notificationDTO);
}
