package com.java.challenge.notificationapi.domain.notification.service;

import com.java.challenge.notificationapi.domain.category.Category;
import com.java.challenge.notificationapi.domain.category.CategoryService;
import com.java.challenge.notificationapi.domain.notification.Notification;
import com.java.challenge.notificationapi.domain.notification.dto.RequestDTO;
import com.java.challenge.notificationapi.domain.notification.dto.ResponseDTO;
import com.java.challenge.notificationapi.domain.notification.validation.RequestValidator;
import com.java.challenge.notificationapi.domain.user.User;
import com.java.challenge.notificationapi.domain.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static com.java.challenge.notificationapi.domain.helper.UserFactoryHelper.createChannelsSet;
import static com.java.challenge.notificationapi.domain.helper.UserFactoryHelper.createOneCategorySet;
import static com.java.challenge.notificationapi.domain.helper.UserFactoryHelper.createThreeCategorySet;
import static com.java.challenge.notificationapi.domain.helper.UserFactoryHelper.createThreeUsers;
import static com.java.challenge.notificationapi.domain.helper.UserFactoryHelper.createTwoCategorySet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

    @Mock
    private CategoryService categoryService;

    @Test
    void shouldReturnResponseSuccess() {
        final Long categoryId = 1L;
        final String categoryName = "SPORTS";
        final String message = "Testing message to send to all channels";

        RequestDTO requestDTO = createRequestDTO(categoryName, message);
        List<User> users = createThreeUsers();
        Set<Category> categorySet = createOneCategorySet(categoryId, categoryName);

        doAnswer(invocationOnMock -> categorySet).when(categoryService).findCategoriesByName(categoryName);
        doAnswer(invocationOnMock -> users).when(userService).getUsersByCategory(categorySet);

        List<ResponseDTO> responseDTOS = notificationService.processRequest(requestDTO);

        assertNotNull(responseDTOS);
        assertEquals(3, responseDTOS.size());

        assertEquals("Alex", responseDTOS.get(0).getUserName());
        assertEquals("John", responseDTOS.get(1).getUserName());
        assertEquals("Brian", responseDTOS.get(2).getUserName());

        assertEquals(createOneCategorySet(), responseDTOS.get(0).getSubscriptions());
        assertEquals(createTwoCategorySet(), responseDTOS.get(1).getSubscriptions());
        assertEquals(createThreeCategorySet(), responseDTOS.get(2).getSubscriptions());

        assertEquals(createChannelsSet(), responseDTOS.get(0).getChannels());
        assertEquals(createChannelsSet(), responseDTOS.get(1).getChannels());
        assertEquals(createChannelsSet(), responseDTOS.get(2).getChannels());

        verify(categoryService, times(1)).findCategoriesByName(categoryName);
        verify(userService, times(1)).getUsersByCategory(categorySet);
    }

    private RequestDTO createRequestDTO(String category, String message) {
        return new RequestDTO.RequestDTOBuilder()
                .category(category)
                .message(message).build();

    }
}