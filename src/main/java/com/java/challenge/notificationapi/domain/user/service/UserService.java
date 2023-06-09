package com.java.challenge.notificationapi.domain.user.service;

import com.java.challenge.notificationapi.domain.notification.Category;
import com.java.challenge.notificationapi.domain.user.User;
import com.java.challenge.notificationapi.domain.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsersByCategory(Category category) {
        List<User> users = userRepository.findAll();

        createSubscribesAndChannelsForUsers(users);

        logger.info("List of all users: {}", users);

        List<User> filteredUsers = new ArrayList<>(users.size());
        for (User user : users) {
            for (Category categoryUser : user.getCategories()) {
                if (categoryUser.equals(category)) {
                    filteredUsers.add(user);
                }
            }
        }

        logger.info("List of users: {} with the following category: {}", filteredUsers, category);

        return filteredUsers;
    }

    private void createSubscribesAndChannelsForUsers(List<User> users) {
        for (User user : users) {
            if (user.getId().equals(1L)) {
                user.setCategories(SubscribesFactory.createSubscribesSetOne());
            }
            if (user.getId().equals(2L)) {
                user.setCategories(SubscribesFactory.createSubscribesSetTwo());
            }
            if (user.getId().equals(3L)) {
                user.setCategories(SubscribesFactory.createSubscribesSetThree());
            }

            user.setChannels(ChannelsFactory.createChannelsSet());
        }
    }
}
