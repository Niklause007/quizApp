package com.springboot.quizapp.dao;

import com.springboot.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);

@Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY Random() LIMIT :numQ",nativeQuery = true)
    List<Question> getRandomQuestionByCategory(String category, int numQ);


}
