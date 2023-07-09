package com.java.challenge.notificationapi.domain.notification.email;

import com.java.challenge.notificationapi.domain.notification.NotificationAbstract;
import com.java.challenge.notificationapi.domain.notification.NotificationType;
import com.java.challenge.notificationapi.domain.notification.dto.NotificationDTO;
import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

@Component
public class EmailNotification extends NotificationAbstract {

    private Logger logger = LoggerFactory.getLogger(EmailNotification.class);

    @Autowired
    private JavaMailSender javaMailSender;

    private static final String EMAIL = "test@gmail.com";
    private static final String SUBJECT = "Testing email sending notification";

    private static final String PATH_TO_EMAIL_TEMPLATE = "templates/emailTemplate.html";

    @Override
    public NotificationType getNotificationType() {
        return NotificationType.EMAIL;
    }

    @Async
    @Override
    public void sendNotification(NotificationDTO notificationDTO) {
        logger.info("Sending message to Email notification");
        logger.info("Data: {}", notificationDTO);

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            mimeMessage.setFrom(new InternetAddress(EMAIL));
            mimeMessage.setRecipients(Message.RecipientType.TO, EMAIL);
            mimeMessage.setSubject(SUBJECT);

            ClassPathResource classPathResource = new ClassPathResource(PATH_TO_EMAIL_TEMPLATE);
            String htmlTemplate = classPathResource.getContentAsString(Charset.defaultCharset());

            htmlTemplate = htmlTemplate.replace("${message}", notificationDTO.getMessage());

            mimeMessage.setContent(htmlTemplate, MediaType.TEXT_HTML_VALUE);

            javaMailSender.send(mimeMessage);

        } catch (Exception ex) {
            logger.error("An error occurred while sending email {}", ex);
            throw new EmailException(ex.getMessage());
        }

    }
}
