package com.springboot.quizapp.controller;

import com.springboot.quizapp.dao.QuestionDao;
import com.springboot.quizapp.entity.Question;
import com.springboot.quizapp.entity.QuestionWrapper;
import com.springboot.quizapp.entity.Response;
import com.springboot.quizapp.service.QuestionService;
import com.springboot.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @Autowired
    QuestionDao questionDao;
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestionById(@PathVariable int id)
    {
        return quizService.getQuestionByID(id);
    }
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title)
    {
        return quizService.createQuiz(category,numQ,title);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses)
    {
        return quizService.calcualateResult(id,responses);
    }

}
