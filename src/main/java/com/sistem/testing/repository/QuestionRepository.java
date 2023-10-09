package com.sistem.testing.repository;

import com.sistem.testing.model.quiz.Question;
import com.sistem.testing.model.quiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Set<Question> findByQuiz(Quiz quiz);
    //TODO: analizar esta funcion
}
