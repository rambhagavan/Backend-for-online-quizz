package com.quizzapp.quizzzpp.model;

import com.quizzapp.quizzzpp.Question;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @ManyToMany
    private List<Question> questions;
    public void setTitle(String title) {
        this.title = title;
    }
    public void setQuestions(List<Question>questions){
        this.questions=questions;
    }
}
