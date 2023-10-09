package com.sistem.testing.service.impl;

import com.sistem.testing.model.quiz.Category;
import com.sistem.testing.repository.CategoryRepository;
import com.sistem.testing.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    public CategoryServiceImpl( CategoryRepository categoryRepository ){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> allCategories() {
        return new HashSet<>( this.categoryRepository.findAll() );
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        this.categoryRepository.deleteById(id);
    }

    @Override
    public Category findById(Long id) {
        return this.categoryRepository.findById(id).get();
    }
}
