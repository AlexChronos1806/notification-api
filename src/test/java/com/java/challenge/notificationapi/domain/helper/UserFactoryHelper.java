package com.java.challenge.notificationapi.domain.helper;

import com.java.challenge.notificationapi.domain.category.Category;
import com.java.challenge.notificationapi.domain.channel.Channel;
import com.java.challenge.notificationapi.domain.user.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserFactoryHelper {

    public static List<User> createOneUser() {
        return List.of(createUserThree());
    }

    public static List<User> createTwoUsers() {
        return List.of(createUserOne(), createUserTwo());
    }
    public static List<User> createThreeUsers() {
        return List.of(createUserOne(), createUserTwo(), createUserThree());
    }

    public static User createUserOne() {
        return new User.UserBuilder()
                .id(1L)
                .name("Alex")
                .email("alex@test.com")
                .phone("123-45677")
                .categories(createOneCategorySet())
                .channels(createChannelsSet())
                .build();
    }

    public static User createUserTwo() {
        return new User.UserBuilder()
                .id(2L)
                .name("John")
                .email("john@test.com")
                .phone("123-22233")
                .categories(createTwoCategorySet())
                .channels(createChannelsSet())
                .build();
    }

    public static User createUserThree() {
        return new User.UserBuilder()
                .id(3L)
                .name("Brian")
                .email("brian@test.com")
                .phone("123-11144")
                .categories(createThreeCategorySet())
                .channels(createChannelsSet())
                .build();
    }

    public static Set<Category> createOneCategorySet(Long id, String name) {
        Set<Category> categories = new HashSet<>(1);
        categories.add(createCategory(id, name));
        return categories;
    }

    public static Set<Category> createOneCategorySet() {
        Set<Category> categories = new HashSet<>(1);
        categories.add(createCategory(1L, "SPORTS"));
        categories.add(createCategory(3L, "FILMS"));
        return categories;
    }

    public static Set<Category> createTwoCategorySet() {
        Set<Category> categories = new HashSet<>(1);
        categories.add(createCategory(1L, "SPORTS"));
        categories.add(createCategory(2L, "FINANCE"));
        categories.add(createCategory(3L, "FILMS"));
        return categories;
    }

    public static Set<Category> createThreeCategorySet() {
        Set<Category> categories = new HashSet<>(1);
        categories.add(createCategory(1L, "SPORTS"));
        return categories;
    }

    public static Category createCategory(Long id, String name) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        return category;
    }

    public static Set<Channel> createChannelsSet() {
        Set<Channel> channels = new HashSet<>(3);
        channels.add(createChannel(1L, "SMS"));
        channels.add(createChannel(2L, "EMAIL"));
        channels.add(createChannel(3L, "PUSH"));
        return channels;
    }

    public static Channel createChannel(Long id, String name) {
        Channel channel = new Channel();
        channel.setId(id);
        channel.setName(name);
        return channel;
    }
}
