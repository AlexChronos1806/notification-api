package com.java.challenge.notificationapi.domain.notification.sms;

import com.java.challenge.notificationapi.domain.notification.NotificationAbstract;
import com.java.challenge.notificationapi.domain.notification.NotificationType;
import com.java.challenge.notificationapi.domain.notification.dto.NotificationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SMSNotification extends NotificationAbstract {

    private Logger logger = LoggerFactory.getLogger(SMSNotification.class);

    @Override
    public NotificationType getNotificationType() {
        return NotificationType.SMS;
    }

    @Override
    public void sendNotification(NotificationDTO notificationDTO) {
        logger.info("Sending message to SMS notification");
        logger.info("Data: {}", notificationDTO);
    }
}
