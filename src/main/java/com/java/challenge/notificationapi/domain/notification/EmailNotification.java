package com.java.challenge.notificationapi.domain.notification;

import com.java.challenge.notificationapi.domain.notification.dto.NotificationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EmailNotification extends NotificationAbstract {

    private Logger logger = LoggerFactory.getLogger(EmailNotification.class);

    @Override
    public NotificationType getNotificationType() {
        return NotificationType.EMAIL;
    }

    @Override
    public void logger(NotificationDTO notificationDTO) {
        logger.info("Sending message to Email notification");
        logger.info("Data: {}", notificationDTO);
    }
}
