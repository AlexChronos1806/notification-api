package com.java.challenge.notificationapi.domain.user.service;

import com.java.challenge.notificationapi.domain.notification.NotificationType;

import java.util.List;

public class ChannelsFactory {

    public static List<NotificationType> createChannelsSet() {
        return List.of(NotificationType.SMS, NotificationType.EMAIL, NotificationType.PUSH);
    }
}
