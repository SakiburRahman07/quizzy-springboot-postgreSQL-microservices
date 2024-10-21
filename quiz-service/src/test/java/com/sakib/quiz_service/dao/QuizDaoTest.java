package com.sakib.quiz_service.dao;

import com.sakib.quiz_service.model.Quiz;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class QuizDaoTest {

    @Autowired
    private QuizDao quizDao;

    @Test
    void testQuizExistsInDatabase() {
        // Step 1: Create and save a quiz in the database
        Quiz quiz = new Quiz();
        quiz.setTitle("Database Test Quiz");
        quiz.setQuestions(List.of(101, 102, 103));
        Quiz savedQuiz = quizDao.save(quiz); // Save it to the in-memory database

        // Step 2: Fetch the quiz from the database using its ID
        Optional<Quiz> fetchedQuiz = quizDao.findById(savedQuiz.getId());

        // Step 3: Check if the quiz is present
        assertTrue(fetchedQuiz.isPresent(), "Quiz should be present in the database");
        assertEquals(savedQuiz.getId(), fetchedQuiz.get().getId(), "Fetched quiz ID should match saved quiz ID");

        // Step 4: Check if a non-existing quiz is not present
        Optional<Quiz> nonExistentQuiz = quizDao.findById(9999); // Assuming this ID doesn't exist
        assertFalse(nonExistentQuiz.isPresent(), "Quiz with non-existent ID should not be present in the database");
    }

}