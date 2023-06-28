package com.java.challenge.notificationapi.domain.category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CategoryService {

    private Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    public Set<Category> findCategoriesByName(String categoryName) {
        Set<Category> categories = categoryRepository.findCategoryByName(categoryName);

        logger.info("List of categories: {}", categories);

        return categories;
    }
}
