package com.sakib.quiz_service.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    Quiz quiz = new Quiz();


    @Test
    void getId() {
        quiz.setId(10);
        int x = quiz.getId();
        assertThat(x).isEqualTo(10);
    }


    @Test
    void getTitle() {
    }

    @Test
    void getQuestions() {
    }

    @Test
    void setId() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void setQuestions() {
    }
}