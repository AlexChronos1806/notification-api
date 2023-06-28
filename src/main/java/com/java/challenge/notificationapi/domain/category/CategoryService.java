package com.java.challenge.notificationapi.domain.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Set<Category> findCategoriesByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }
}
