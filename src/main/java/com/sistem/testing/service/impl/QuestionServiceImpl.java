package com.sistem.testing.service.impl;

import com.sistem.testing.model.quiz.Question;
import com.sistem.testing.model.quiz.Quiz;
import com.sistem.testing.repository.QuestionRepository;
import com.sistem.testing.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;
    public QuestionServiceImpl( QuestionRepository questionRepository ){
        this.questionRepository = questionRepository;
    }

    @Override
    public Question saveQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> allQuestions() {
        return new HashSet<>( this.questionRepository.findAll() );
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long id) {
        this.questionRepository.deleteById(id);
    }

    @Override
    public Question findById(Long id) {
        return this.questionRepository.findById(id).get();
    }

    @Override
    public Set<Question> findAllQuestionsOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }
}
