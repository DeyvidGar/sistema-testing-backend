package com.sistem.testing.service.impl;

import com.sistem.testing.model.quiz.Category;
import com.sistem.testing.model.quiz.Question;
import com.sistem.testing.model.quiz.Quiz;
import com.sistem.testing.repository.CategoryRepository;
import com.sistem.testing.repository.QuizRepository;
import com.sistem.testing.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;
    public QuizServiceImpl( QuizRepository quizRepository ){
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz saveQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> allQuizzes() {
        return new HashSet<>( this.quizRepository.findAll() );
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public void deleteQuiz(Long id) {
        this.quizRepository.deleteById(id);
    }

    @Override
    public Quiz findQuizById(Long id) {
        return this.quizRepository.findById(id).get();
    }

    @Override
    public List<Quiz> findByCategory(Category category) {
        return this.quizRepository.findByCategory(category);
    }

    @Override
    public List<Quiz> listQuizzesByActive() {
        return this.quizRepository.findByActiveTrue();
    }

    @Override
    public List<Quiz> listQuizzesByCategoryAndActive(Category category) {
        return this.quizRepository.findByCategoryAndActiveTrue(category);
    }
}
