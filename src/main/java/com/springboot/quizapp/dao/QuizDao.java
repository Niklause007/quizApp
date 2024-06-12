package com.springboot.quizapp.dao;

import com.springboot.quizapp.entity.Question;
import com.springboot.quizapp.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {


}
