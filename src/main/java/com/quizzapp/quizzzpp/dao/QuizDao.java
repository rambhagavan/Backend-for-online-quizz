package com.quizzapp.quizzzpp.dao;

import com.quizzapp.quizzzpp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
