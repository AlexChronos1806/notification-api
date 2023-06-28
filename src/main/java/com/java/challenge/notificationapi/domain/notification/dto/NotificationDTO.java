package com.java.challenge.notificationapi.domain.notification.dto;

import com.java.challenge.notificationapi.domain.notification.CategoryType;
import com.java.challenge.notificationapi.domain.notification.NotificationType;

import java.time.LocalDateTime;

public class NotificationDTO {

    private String message;
    private CategoryType categoryType;
    private NotificationType notificationType;
    private LocalDateTime dateTime;

    private NotificationDTO(NotificationDTOBuilder notificationDTOBuilder) {
        this.message = notificationDTOBuilder.message;
        this.categoryType = notificationDTOBuilder.categoryType;
        this.notificationType = notificationDTOBuilder.notificationType;
        this.dateTime = notificationDTOBuilder.dateTime;
    }

    public NotificationDTO() {
    }

    public String getMessage() {
        return message;
    }

    public CategoryType getCategoryType() {
        return categoryType;
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
                ", categoryType=" + categoryType +
                ", notificationType=" + notificationType +
                ", dateTime=" + dateTime +
                '}';
    }

    public static class NotificationDTOBuilder {
        private String message;
        private CategoryType categoryType;
        private NotificationType notificationType;
        private LocalDateTime dateTime;

        public NotificationDTOBuilder message(String message) {
            this.message = message;
            return this;
        }

        public NotificationDTOBuilder categoryType(CategoryType categoryType) {
            this.categoryType = categoryType;
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
