package com.java.challenge.notificationapi.domain.notification.dto;

import com.java.challenge.notificationapi.domain.notification.Category;
import com.java.challenge.notificationapi.domain.notification.NotificationType;

import java.time.LocalDateTime;

public class NotificationDTO {

    private String message;
    private Category category;
    private NotificationType notificationType;
    private LocalDateTime dateTime;

    private NotificationDTO(NotificationDTOBuilder notificationDTOBuilder) {
        this.message = notificationDTOBuilder.message;
        this.category = notificationDTOBuilder.category;
        this.notificationType = notificationDTOBuilder.notificationType;
        this.dateTime = notificationDTOBuilder.dateTime;
    }

    public NotificationDTO() {
    }

    public String getMessage() {
        return message;
    }

    public Category getCategory() {
        return category;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "NotificationDTO{" +
                "message='" + message + '\'' +
                ", category=" + category +
                ", notificationType=" + notificationType +
                ", dateTime=" + dateTime +
                '}';
    }

    public static class NotificationDTOBuilder {
        private String message;
        private Category category;
        private NotificationType notificationType;
        private LocalDateTime dateTime;

        public NotificationDTOBuilder message(String message) {
            this.message = message;
            return this;
        }

        public NotificationDTOBuilder category(Category category) {
            this.category = category;
            return this;
        }

        public NotificationDTOBuilder notificationType(NotificationType notificationType) {
            this.notificationType = notificationType;
            return this;
        }

        public NotificationDTOBuilder dateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public NotificationDTO build() {
            return new NotificationDTO(this);
        }
    }
}
