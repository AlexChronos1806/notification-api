package com.java.challenge.notificationapi.domain.user;

import com.java.challenge.notificationapi.domain.category.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsersByCategory(Set<Category> categorySet) {
        List<User> users = userRepository.findUserByCategorySetIn(categorySet);

        logger.info("List of all users: {}", users);

        return users;
    }
}
