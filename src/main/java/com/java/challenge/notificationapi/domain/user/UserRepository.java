package com.java.challenge.notificationapi.domain.user;

import com.java.challenge.notificationapi.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUserByCategorySetIn(Set<Category> categorySet);
}
