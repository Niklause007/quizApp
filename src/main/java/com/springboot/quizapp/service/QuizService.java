package com.springboot.quizapp.service;

import com.springboot.quizapp.dao.QuestionDao;
import com.springboot.quizapp.dao.QuizDao;
import com.springboot.quizapp.entity.Question;
import com.springboot.quizapp.entity.QuestionWrapper;
import com.springboot.quizapp.entity.Quiz;
import com.springboot.quizapp.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions=questionDao.getRandomQuestionByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        return  new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionByID(int id) {
        Optional<Quiz> quiz=quizDao.findById(id);
        List<Question> questionFromDB=quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser=new ArrayList<>();
        for(Question q:questionFromDB)
        {
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qw);

        }
        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calcualateResult(Integer id, List<Response> responses) {
        Quiz quiz=quizDao.findById(id).get();
        List<Question> question=quiz.getQuestions();
        int answer=0;
        int i=0;
        for(Response response:responses)
        {
            if(response.getResponse().equals(question.get(i).getRightAnswer()))
            {
                answer++;

            }

            i++;

        }
        return new ResponseEntity<>(answer,HttpStatus.OK);


    }
}
