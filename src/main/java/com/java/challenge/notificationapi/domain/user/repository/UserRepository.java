package com.java.challenge.notificationapi.domain.user.repository;

import com.java.challenge.notificationapi.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
