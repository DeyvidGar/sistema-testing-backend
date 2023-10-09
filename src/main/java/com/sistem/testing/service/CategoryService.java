package com.sistem.testing.service;

import com.sistem.testing.model.quiz.Category;

import java.util.Set;

public interface CategoryService {
    Category saveCategory(Category category);

    Set<Category> allCategories();

    Category updateCategory(Category category);

    void deleteCategory(Long id);

    Category findById(Long id);
}
