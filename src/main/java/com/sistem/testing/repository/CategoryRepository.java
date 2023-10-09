package com.sistem.testing.repository;

import com.sistem.testing.model.quiz.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
