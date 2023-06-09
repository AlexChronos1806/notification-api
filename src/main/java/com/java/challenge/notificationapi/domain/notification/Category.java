package com.java.challenge.notificationapi.domain.notification;

public enum Category {

    SPORTS, FINANCE, FILMS;

    public static Category getCategory(String category) {
        for (Category categoryEnum : Category.values()) {
            if (categoryEnum.name().equalsIgnoreCase(category)) {
                return categoryEnum;
            }
        }

        return null;
    }
}
