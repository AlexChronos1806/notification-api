package com.java.challenge.notificationapi.domain.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Set<Category> findCategoryByName(String name);
}
