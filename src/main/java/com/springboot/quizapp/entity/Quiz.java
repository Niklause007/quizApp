package com.springboot.quizapp.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Quiz {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
@ManyToMany
    private List<Question> questions;

    public Quiz() {
        super();
    }


    public Quiz(Integer id, String title, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.questions = questions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", questions=" + questions +
                '}';
    }


}
