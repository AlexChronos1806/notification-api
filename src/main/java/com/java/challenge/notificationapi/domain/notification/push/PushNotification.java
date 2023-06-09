package com.java.challenge.notificationapi.domain.notification.push;

import com.java.challenge.notificationapi.domain.notification.NotificationAbstract;
import com.java.challenge.notificationapi.domain.notification.NotificationType;
import com.java.challenge.notificationapi.domain.notification.dto.NotificationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PushNotification extends NotificationAbstract {

    private Logger logger = LoggerFactory.getLogger(PushNotification.class);

    @Override
    public NotificationType getNotificationType() {
        return NotificationType.PUSH;
    }

    @Override
    public void sendNotification(NotificationDTO notificationDTO) {
        logger.info("Sending message to Push notification");
        logger.info("Data: {}", notificationDTO);
    }
}
