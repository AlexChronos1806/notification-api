package com.java.challenge.notificationapi.domain.notification;

import com.java.challenge.notificationapi.domain.notification.dto.NotificationDTO;

import java.time.LocalDateTime;

public abstract class NotificationAbstract implements Notification {

    @Override
    public NotificationDTO send(Category category, String message) {
        NotificationDTO notificationDTO = new NotificationDTO.NotificationDTOBuilder()
                .message(message)
                .category(category)
                .notificationType(getNotificationType())
                .dateTime(LocalDateTime.now()).build();

        logger(notificationDTO);

        return notificationDTO;
    }

    protected abstract void logger(NotificationDTO notificationDTO);
}
