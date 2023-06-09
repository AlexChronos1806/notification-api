package com.java.challenge.notificationapi.domain.user.service;

import com.java.challenge.notificationapi.domain.notification.Category;
import com.java.challenge.notificationapi.domain.notification.NotificationType;
import com.java.challenge.notificationapi.domain.user.User;
import com.java.challenge.notificationapi.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @Test
    void shouldReturnAListOfUsersByCategorySports() {
        final Category category = Category.SPORTS;
        List<User> users = createUsers();

        Mockito.when(userRepository.findAll()).thenReturn(users);

        List<User> usersByCategory = userService.getUsersByCategory(category);

        Assertions.assertNotNull(usersByCategory);
        Assertions.assertEquals(3, usersByCategory.size());

        Assertions.assertEquals("Alex", usersByCategory.get(0).getName());
        Assertions.assertEquals("John", usersByCategory.get(1).getName());
        Assertions.assertEquals("Brian", usersByCategory.get(2).getName());

        Assertions.assertEquals(List.of(Category.FILMS, Category.SPORTS), usersByCategory.get(0).getCategories());
        Assertions.assertEquals(List.of(Category.FINANCE, Category.SPORTS, Category.FILMS), usersByCategory.get(1).getCategories());
        Assertions.assertEquals(List.of(Category.SPORTS), usersByCategory.get(2).getCategories());

        Assertions.assertEquals(List.of(NotificationType.SMS, NotificationType.EMAIL, NotificationType.PUSH), usersByCategory.get(0).getChannels());
        Assertions.assertEquals(List.of(NotificationType.SMS, NotificationType.EMAIL, NotificationType.PUSH), usersByCategory.get(1).getChannels());
        Assertions.assertEquals(List.of(NotificationType.SMS, NotificationType.EMAIL, NotificationType.PUSH), usersByCategory.get(2).getChannels());

        Mockito.verify(userRepository, Mockito.times(1)).findAll();
    }

    @Test
    void shouldReturnAListOfUsersByCategoryFinance() {
        final Category category = Category.FINANCE;
        List<User> users = createUsers();

        Mockito.when(userRepository.findAll()).thenReturn(users);

        List<User> usersByCategory = userService.getUsersByCategory(category);

        Assertions.assertNotNull(usersByCategory);
        Assertions.assertEquals(1, usersByCategory.size());

        Assertions.assertEquals("John", usersByCategory.get(0).getName());
        Assertions.assertEquals(List.of(Category.FINANCE, Category.SPORTS, Category.FILMS), usersByCategory.get(0).getCategories());

        Assertions.assertEquals(List.of(NotificationType.SMS, NotificationType.EMAIL, NotificationType.PUSH), usersByCategory.get(0).getChannels());

        Mockito.verify(userRepository, Mockito.times(1)).findAll();
    }

    @Test
    void shouldReturnAListOfUsersByCategoryFilms() {
        final Category category = Category.FILMS;
        List<User> users = createUsers();

        Mockito.when(userRepository.findAll()).thenReturn(users);

        List<User> usersByCategory = userService.getUsersByCategory(category);

        Assertions.assertNotNull(usersByCategory);
        Assertions.assertEquals(2, usersByCategory.size());

        Assertions.assertEquals("Alex", usersByCategory.get(0).getName());
        Assertions.assertEquals("John", usersByCategory.get(1).getName());

        Assertions.assertEquals(List.of(Category.FILMS, Category.SPORTS), usersByCategory.get(0).getCategories());
        Assertions.assertEquals(List.of(Category.FINANCE, Category.SPORTS, Category.FILMS), usersByCategory.get(1).getCategories());

        Assertions.assertEquals(List.of(NotificationType.SMS, NotificationType.EMAIL, NotificationType.PUSH), usersByCategory.get(0).getChannels());
        Assertions.assertEquals(List.of(NotificationType.SMS, NotificationType.EMAIL, NotificationType.PUSH), usersByCategory.get(1).getChannels());

        Mockito.verify(userRepository, Mockito.times(1)).findAll();
    }

    private List<User> createUsers() {
        return List.of(createUserOne(), createUserTwo(), createUserThree());
    }

    private User createUserOne() {
        return new User.UserBuilder()
                .id(1L)
                .name("Alex")
                .email("alex@test.com")
                .phone("123-45677")
                .build();
    }

    private User createUserTwo() {
        return new User.UserBuilder()
                .id(2L)
                .name("John")
                .email("john@test.com")
                .phone("123-22233")
                .build();
    }

    private User createUserThree() {
        return new User.UserBuilder()
                .id(3L)
                .name("Brian")
                .email("brian@test.com")
                .phone("123-11144")
                .build();
    }
}