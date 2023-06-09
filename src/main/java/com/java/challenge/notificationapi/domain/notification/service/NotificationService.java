package com.java.challenge.notificationapi.domain.notification.service;

import com.java.challenge.notificationapi.domain.notification.Category;
import com.java.challenge.notificationapi.domain.notification.Notification;
import com.java.challenge.notificationapi.domain.notification.dto.NotificationDTO;
import com.java.challenge.notificationapi.domain.notification.dto.RequestDTO;
import com.java.challenge.notificationapi.domain.notification.dto.ResponseDTO;
import com.java.challenge.notificationapi.domain.notification.validation.RequestValidator;
import com.java.challenge.notificationapi.domain.user.User;
import com.java.challenge.notificationapi.domain.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<ResponseDTO> processRequest(RequestDTO requestDTO) {
        validations.forEach(validate -> validate.validate(requestDTO));

        Category category = Category.getCategory(requestDTO.getCategory());

        List<User> users = userService.getUsersByCategory(category);

        List<NotificationDTO> notificationDTOS = notifications.stream()
                .map(notification -> notification.send(category, requestDTO.getMessage()))
                .collect(Collectors.toList());

        return users.stream().map(user -> new ResponseDTO(user, notificationDTOS)).collect(Collectors.toList());
    }
}
