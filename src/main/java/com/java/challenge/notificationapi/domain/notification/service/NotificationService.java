package com.java.challenge.notificationapi.domain.notification.service;

import com.java.challenge.notificationapi.domain.category.Category;
import com.java.challenge.notificationapi.domain.category.CategoryNotFoundException;
import com.java.challenge.notificationapi.domain.category.CategoryService;
import com.java.challenge.notificationapi.domain.notification.CategoryType;
import com.java.challenge.notificationapi.domain.notification.Notification;
import com.java.challenge.notificationapi.domain.notification.dto.NotificationDTO;
import com.java.challenge.notificationapi.domain.notification.dto.RequestDTO;
import com.java.challenge.notificationapi.domain.notification.dto.ResponseDTO;
import com.java.challenge.notificationapi.domain.notification.validation.RequestValidator;
import com.java.challenge.notificationapi.domain.user.User;
import com.java.challenge.notificationapi.domain.user.UserNotFoundException;
import com.java.challenge.notificationapi.domain.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    private List<RequestValidator> validations;

    @Autowired
    private List<Notification> notifications;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    public List<ResponseDTO> processRequest(RequestDTO requestDTO) {
        validations.forEach(validate -> validate.validate(requestDTO));

        Set<Category> categories = getCategories(requestDTO.getCategory());
        List<User> users = getUsers(categories);

        CategoryType categoryType = CategoryType.getCategory(requestDTO.getCategory());
        List<NotificationDTO> notificationDTOS = sendNotifications(categoryType, requestDTO.getMessage());

        return createResponseDTO(users, notificationDTOS);
    }

    private Set<Category> getCategories(String categoryName) {
        Set<Category> categoriesByName = categoryService.findCategoriesByName(categoryName);

        if (categoriesByName.isEmpty()) {
            throw new CategoryNotFoundException("No category found!!");
        }

        return categoriesByName;
    }

    private List<User> getUsers(Set<Category> categories) {
        List<User> usersByCategory = userService.getUsersByCategory(categories);

        if (usersByCategory.isEmpty()) {
            throw new UserNotFoundException("No user found!!");
        }

        return usersByCategory;
    }

    private List<NotificationDTO> sendNotifications(CategoryType categoryType, String message) {
        return notifications.stream()
                .map(notification -> notification.createNotification(categoryType, message))
                .collect(Collectors.toList());
    }

    private List<ResponseDTO> createResponseDTO(List<User> users, List<NotificationDTO> notificationDTOS) {
        return users.stream()
                .map(user -> new ResponseDTO(user, notificationDTOS))
                .collect(Collectors.toList());
    }
}
