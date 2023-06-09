package com.java.challenge.notificationapi.domain.notification.dto;

import com.java.challenge.notificationapi.domain.notification.Category;
import com.java.challenge.notificationapi.domain.notification.NotificationType;
import com.java.challenge.notificationapi.domain.user.User;

import java.util.List;

public class ResponseDTO {

    private Long userId;
    private String userName;
    private String userEmail;
    private String userPhone;
    private List<Category> subscriptions;
    private List<NotificationType> channels;

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public List<Category> getSubscriptions() {
        return subscriptions;
    }

    public List<NotificationType> getChannels() {
        return channels;
    }

    public ResponseDTO(User user) {
        this.userId = user.getId();
        this.userName = user.getName();
        this.userEmail = user.getEmail();
        this.userPhone = user.getPhone();
        this.subscriptions = user.getCategories();
        this.channels = user.getChannels();
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", subscriptions=" + subscriptions +
                ", channels=" + channels +
                '}';
    }
}