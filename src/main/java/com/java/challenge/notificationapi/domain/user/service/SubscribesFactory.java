package com.java.challenge.notificationapi.domain.user.service;

import com.java.challenge.notificationapi.domain.notification.Category;

import java.util.List;

public class SubscribesFactory {

    public static List<Category> createSubscribesSetOne() {
        return List.of(Category.FILMS, Category.SPORTS);
    }

    public static List<Category> createSubscribesSetTwo() {
        return List.of(Category.FINANCE, Category.SPORTS, Category.FILMS);
    }

    public static List<Category> createSubscribesSetThree() {
        return List.of(Category.SPORTS);
    }
}
