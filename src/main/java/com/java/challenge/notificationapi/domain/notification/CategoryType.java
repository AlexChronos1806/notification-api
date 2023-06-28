package com.java.challenge.notificationapi.domain.notification;

public enum CategoryType {

    SPORTS, FINANCE, FILMS;

    public static CategoryType getCategory(String category) {
        for (CategoryType categoryTypeEnum : CategoryType.values()) {
            if (categoryTypeEnum.name().equalsIgnoreCase(category)) {
                return categoryTypeEnum;
            }
        }

        return null;
    }
}
