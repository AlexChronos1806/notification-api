package com.java.challenge.notificationapi.domain.user.service;

import com.java.challenge.notificationapi.domain.category.Category;
import com.java.challenge.notificationapi.domain.user.User;
import com.java.challenge.notificationapi.domain.user.UserRepository;
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
import static com.java.challenge.notificationapi.domain.helper.UserFactoryHelper.createOneUser;
import static com.java.challenge.notificationapi.domain.helper.UserFactoryHelper.createThreeCategorySet;
import static com.java.challenge.notificationapi.domain.helper.UserFactoryHelper.createThreeUsers;
import static com.java.challenge.notificationapi.domain.helper.UserFactoryHelper.createTwoCategorySet;
import static com.java.challenge.notificationapi.domain.helper.UserFactoryHelper.createTwoUsers;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @Test
    void shouldReturnAListOfUsersByCategorySports() {
        Set<Category> categorySet = createOneCategorySet(1L, "SPORTS");

        when(userRepository.findUserByCategorySetIn(categorySet)).thenReturn(createThreeUsers());

        List<User> usersByCategory = userService.getUsersByCategory(categorySet);

        assertNotNull(usersByCategory);
        assertEquals(3, usersByCategory.size());

        assertEquals("Alex", usersByCategory.get(0).getName());
        assertEquals("John", usersByCategory.get(1).getName());
        assertEquals("Brian", usersByCategory.get(2).getName());

        assertEquals(createOneCategorySet(), usersByCategory.get(0).getCategorySet());
        assertEquals(createTwoCategorySet(), usersByCategory.get(1).getCategorySet());
        assertEquals(createThreeCategorySet(), usersByCategory.get(2).getCategorySet());

        assertEquals(createChannelsSet(), usersByCategory.get(0).getChannelSet());
        assertEquals(createChannelsSet(), usersByCategory.get(1).getChannelSet());
        assertEquals(createChannelsSet(), usersByCategory.get(2).getChannelSet());

        verify(userRepository, times(1)).findUserByCategorySetIn(categorySet);
    }

    @Test
    void shouldReturnAListOfUsersByCategoryFinance() {
        Set<Category> categorySet = createOneCategorySet(2L, "FINANCE");

        when(userRepository.findUserByCategorySetIn(categorySet)).thenReturn(createOneUser());

        List<User> usersByCategory = userService.getUsersByCategory(categorySet);

        assertNotNull(usersByCategory);
        assertEquals(1, usersByCategory.size());

        assertEquals("Brian", usersByCategory.get(0).getName());

        assertEquals(createThreeCategorySet(), usersByCategory.get(0).getCategorySet());

        assertEquals(createChannelsSet(), usersByCategory.get(0).getChannelSet());

        verify(userRepository, times(1)).findUserByCategorySetIn(categorySet);
    }

    @Test
    void shouldReturnAListOfUsersByCategoryFilms() {
        Set<Category> categorySet = createOneCategorySet(3L, "FILMS");

        when(userRepository.findUserByCategorySetIn(categorySet)).thenReturn(createTwoUsers());

        List<User> usersByCategory = userService.getUsersByCategory(categorySet);

        assertNotNull(usersByCategory);
        assertEquals(2, usersByCategory.size());

        assertEquals("Alex", usersByCategory.get(0).getName());
        assertEquals("John", usersByCategory.get(1).getName());

        assertEquals(createOneCategorySet(), usersByCategory.get(0).getCategorySet());
        assertEquals(createTwoCategorySet(), usersByCategory.get(1).getCategorySet());

        assertEquals(createChannelsSet(), usersByCategory.get(0).getChannelSet());
        assertEquals(createChannelsSet(), usersByCategory.get(1).getChannelSet());

        verify(userRepository, times(1)).findUserByCategorySetIn(categorySet);
    }
}