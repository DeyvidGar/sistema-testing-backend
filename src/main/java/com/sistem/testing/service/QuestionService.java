package com.sistem.testing.service;

import com.sistem.testing.model.quiz.Question;
import com.sistem.testing.model.quiz.Quiz;

import java.util.Set;

public interface QuestionService {
    Question saveQuestion(Question question);

    Set<Question> allQuestions();

    Question updateQuestion(Question question);

    void deleteQuestion(Long id);

    Question findById(Long id);

    Set<Question> findAllQuestionsOfQuiz(Quiz quiz);
}
