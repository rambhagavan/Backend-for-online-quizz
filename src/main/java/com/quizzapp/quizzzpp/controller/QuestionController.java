package com.quizzapp.quizzzpp.controller;

import com.quizzapp.quizzzpp.Question;
import com.quizzapp.quizzzpp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestion")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestions();
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getAllQuestionByCategory(@PathVariable String category){
        return questionService.getAllQuestionByCategory(category);
    }
    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        System.out.println(question);
        return questionService.addQuestion(question);
    }
}
