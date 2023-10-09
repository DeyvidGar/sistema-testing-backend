package com.sistem.testing.repository;

import com.sistem.testing.model.quiz.Category;
import com.sistem.testing.model.quiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> findByCategory(Category category);

    List<Quiz> findByActiveTrue();

    List<Quiz> findByCategoryAndActiveTrue(Category category);
}
