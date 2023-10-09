package com.sistem.testing.service;

import com.sistem.testing.model.quiz.Category;
import com.sistem.testing.model.quiz.Question;
import com.sistem.testing.model.quiz.Quiz;

import java.util.List;
import java.util.Set;

public interface QuizService {
    Quiz saveQuiz(Quiz quiz);

    Set<Quiz> allQuizzes();

    Quiz updateQuiz(Quiz quiz);

    void deleteQuiz(Long id);

    Quiz findQuizById(Long id);

    List<Quiz> findByCategory(Category category);

    List<Quiz> listQuizzesByActive();

    List<Quiz> listQuizzesByCategoryAndActive(Category category);
}
