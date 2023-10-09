package com.sistem.testing.controller.rest;

import com.sistem.testing.model.quiz.Question;
import com.sistem.testing.service.QuestionService;
import com.sistem.testing.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/question")
public class QuestionRestController {

    private QuestionService questionService;
    private QuizService quizService;
    public QuestionRestController( QuestionService questionService, QuizService quizService ) {
        this.questionService = questionService;
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<Question> saveQuestion( @RequestBody Question question ) {
        return ResponseEntity.ok( this.questionService.saveQuestion( question ) );
    }

    @GetMapping
    public ResponseEntity< Set<Question> > allQuestions() {
        return ResponseEntity.ok( this.questionService.allQuestions() );
    }

    @PutMapping
    public ResponseEntity<Question> updateQuestion( @RequestBody Question question ) {
        return ResponseEntity.ok( this.questionService.updateQuestion(question) );
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion( @PathVariable long id ) {
        this.questionService.deleteQuestion( id );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> findQuestionById( @PathVariable long id ) {
        return ResponseEntity.ok( this.questionService.findById( id ) );
    }

    //mostramos todas preguntas relacionadas con un examen
    @GetMapping("/quiz/{id}")
    public ResponseEntity< Set<Question> > allQuestionOfQuiz( @PathVariable long id ) {
        return ResponseEntity.ok( this.questionService.findAllQuestionsOfQuiz( this.quizService.findQuizById( id ) ) );
    }
}
