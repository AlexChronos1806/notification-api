package com.java.challenge.notificationapi.domain.notification.service;

import com.java.challenge.notificationapi.domain.notification.Category;
import com.java.challenge.notificationapi.domain.notification.Notification;
import com.java.challenge.notificationapi.domain.notification.NotificationType;
import com.java.challenge.notificationapi.domain.notification.dto.RequestDTO;
import com.java.challenge.notificationapi.domain.notification.dto.ResponseDTO;
import com.java.challenge.notificationapi.domain.notification.validation.RequestValidator;
import com.java.challenge.notificationapi.domain.user.User;
import com.java.challenge.notificationapi.domain.user.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {

    @InjectMocks
    private NotificationService notificationService;

    @Mock
    private List<RequestValidator> validations;

    @Mock
    private List<Notification> notifications;

    @Mock
    private UserService userService;

    @Test
    void shouldReturnResponseSuccess() {
        RequestDTO requestDTO = createRequestDTO("SPORTS", "Testing message to send to all channels");
        List<User> users = createUsers();

        Mockito.doAnswer(invocationOnMock -> users).when(userService).getUsersByCategory(Category.SPORTS);

        List<ResponseDTO> responseDTOS = notificationService.processRequest(requestDTO);

        Assertions.assertNotNull(responseDTOS);
        Assertions.assertEquals(3, responseDTOS.size());

        Assertions.assertEquals("Alex", responseDTOS.get(0).getUserName());
        Assertions.assertEquals("John", responseDTOS.get(1).getUserName());
        Assertions.assertEquals("Brian", responseDTOS.get(2).getUserName());

        Assertions.assertEquals(List.of(Category.FILMS, Category.SPORTS), responseDTOS.get(0).getSubscriptions());
        Assertions.assertEquals(List.of(Category.FINANCE, Category.SPORTS, Category.FILMS), responseDTOS.get(1).getSubscriptions());
        Assertions.assertEquals(List.of(Category.SPORTS), responseDTOS.get(2).getSubscriptions());

        Assertions.assertEquals(List.of(NotificationType.SMS, NotificationType.EMAIL, NotificationType.PUSH), responseDTOS.get(0).getChannels());
        Assertions.assertEquals(List.of(NotificationType.SMS, NotificationType.EMAIL, NotificationType.PUSH), responseDTOS.get(1).getChannels());
        Assertions.assertEquals(List.of(NotificationType.SMS, NotificationType.EMAIL, NotificationType.PUSH), responseDTOS.get(2).getChannels());

        Mockito.verify(userService, Mockito.times(1)).getUsersByCategory(Category.SPORTS);
    }

    private RequestDTO createRequestDTO(String category, String message) {
        return new RequestDTO.RequestDTOBuilder()
                .category(category)
                .message(message).build();

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
                .categories(List.of(Category.FILMS, Category.SPORTS))
                .channels(List.of(NotificationType.SMS, NotificationType.EMAIL, NotificationType.PUSH))
                .build();
    }

    private User createUserTwo() {
        return new User.UserBuilder()
                .id(2L)
                .name("John")
                .email("john@test.com")
                .phone("123-22233")
                .categories(List.of(Category.FINANCE, Category.SPORTS, Category.FILMS))
                .channels(List.of(NotificationType.SMS, NotificationType.EMAIL, NotificationType.PUSH))
                .build();
    }

    private User createUserThree() {
        return new User.UserBuilder()
                .id(3L)
                .name("Brian")
                .email("brian@test.com")
                .phone("123-11144")
                .categories(List.of(Category.SPORTS))
                .channels(List.of(NotificationType.SMS, NotificationType.EMAIL, NotificationType.PUSH))
                .build();
    }
}