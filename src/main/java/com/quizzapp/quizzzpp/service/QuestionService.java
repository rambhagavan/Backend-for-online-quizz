package com.quizzapp.quizzzpp.service;
import com.quizzapp.quizzzpp.Question;
import com.quizzapp.quizzzpp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao QuestionDao;
    public ResponseEntity<List<Question>> getAllQuestions(){
        try {
            return new ResponseEntity<>(QuestionDao.findAll(), HttpStatus.OK);
        }
        catch(Exception e ){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Question>> getAllQuestionByCategory(String category){
        try {
            return new ResponseEntity<>(QuestionDao.findByCategory(category), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<Question>(),HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> addQuestion(Question question){
        try {
            QuestionDao.save(question);
            return  new ResponseEntity<>("Question is added Successfully",HttpStatus.CREATED);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return  new ResponseEntity<>("Something is wrong",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
