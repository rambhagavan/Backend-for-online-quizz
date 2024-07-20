package com.quizzapp.quizzzpp.service;

import com.quizzapp.quizzzpp.Question;
import com.quizzapp.quizzzpp.dao.QuestionDao;
import com.quizzapp.quizzzpp.dao.QuizDao;
import com.quizzapp.quizzzpp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<String> createQuiz(String category,int numQ,String title){
        List<Question> questions=questionDao.findRandomQuestionByCategory(category,numQ);
         Quiz quiz=new Quiz();
         quiz.setTitle(title);
         quiz.setQuestions(questions);
         quizDao.save(quiz);
         return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
