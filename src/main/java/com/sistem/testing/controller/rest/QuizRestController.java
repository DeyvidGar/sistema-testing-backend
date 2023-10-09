package com.sistem.testing.controller.rest;

import com.sistem.testing.model.quiz.Category;
import com.sistem.testing.model.quiz.Question;
import com.sistem.testing.model.quiz.Quiz;
import com.sistem.testing.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/quiz")
public class QuizRestController {

    private QuizService quizService;
    public QuizRestController( QuizService quizService ){
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<Quiz> saveQuiz( @RequestBody Quiz quiz ){
        return ResponseEntity.ok( this.quizService.saveQuiz( quiz ) );
    }

    @GetMapping
    public ResponseEntity< Set<Quiz> > allQuizzes(){
        return ResponseEntity.ok( this.quizService.allQuizzes() );
    }

    @PutMapping
    public ResponseEntity<Quiz> updateQuiz( @RequestBody Quiz quiz ){
        return ResponseEntity.ok( this.quizService.updateQuiz( quiz ) );
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz( @PathVariable long id ){
        this.quizService.deleteQuiz(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> findQuizById( @PathVariable long id ){
        return ResponseEntity.ok( this.quizService.findQuizById( id ) );
    }

    //metodo para obtener un examen con el numero de preguntas ingresadas por el usuario, en un orden aleatorio.
    @GetMapping("/apply/{id}")
    public ResponseEntity< List<Question> > listQuestionsOfQuiz( @PathVariable long id ){
        Quiz quiz = this.quizService.findQuizById( id );

        List<Question> questions = new ArrayList<>( quiz.getQuestions() );
        Collections.shuffle( questions );

        //para obtener solo el number de preguntas que especifico
        if ( questions.size() > Integer.parseInt( quiz.getNumQuestions() ) ){
            //creaamos la lista solo con el numero de preguntas que especifico
            questions = questions.subList( 0, Integer.parseInt( quiz.getNumQuestions() ) );
        }

        return ResponseEntity.ok( questions );
    }

    //find all quiz of a category
    @GetMapping("/by-category/{id}")
    public ResponseEntity<List<Quiz>> listQuizzesOfCategory( @PathVariable long id ) {
        return ResponseEntity.ok( this.quizService.findByCategory( new Category( id ) ) );
    }

    //list of quiz actives
    @GetMapping("/active")
    public ResponseEntity<List<Quiz>> listQuizzesActive() {
        return ResponseEntity.ok( this.quizService.listQuizzesByActive() );
    }

    //list quiz by category that only are active
    @GetMapping("/active/by-category/{id}")
    public ResponseEntity<List<Quiz>> listQuizzesActiveAndByCategory( @PathVariable long id ) {
        return ResponseEntity.ok( this.quizService.listQuizzesByCategoryAndActive( new Category(id) ) );
    }
}
