package com.sistem.testing.model.quiz;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sistem.testing.model.quiz.Category;
import com.sistem.testing.model.quiz.Question;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean active = false;//false: examen no disponible para alumnos
    private String description;
    private String numQuestions;
    private String maxPoints;
    private String title;

    //relacion m 1
//    @JsonIgnore
    @JoinColumn(name = "category_id")
    @ManyToOne()
    private Category category;

    //relacion inversa 1 m
    @JsonIgnore
    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private Set<Question> questions;

    public Quiz() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumQuestions() {
        return numQuestions;
    }

    public void setNumQuestions(String numQuestions) {
        this.numQuestions = numQuestions;
    }

    public String getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(String maxPoints) {
        this.maxPoints = maxPoints;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", active=" + active +
                ", description='" + description + '\'' +
                ", numQuestions='" + numQuestions + '\'' +
                ", maxPoints='" + maxPoints + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
