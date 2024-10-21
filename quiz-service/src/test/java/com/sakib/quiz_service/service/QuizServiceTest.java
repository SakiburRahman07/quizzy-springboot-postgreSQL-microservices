package com.sakib.quiz_service.service;

import com.sakib.quiz_service.dao.QuizDao;
import com.sakib.quiz_service.feign.QuizInterface;
import com.sakib.quiz_service.model.QuestionWrapper;
import com.sakib.quiz_service.model.Quiz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class QuizServiceTest {

    @InjectMocks
    private QuizService quizService;

    @Mock
    private QuizDao quizDao;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getQuizQuestions() {
        // Mocking dependencies
        QuizDao quizDao = mock(QuizDao.class);
        QuizInterface quizInterface = mock(QuizInterface.class);

        // Setting up QuizService and injecting mocks
        QuizService quizService = new QuizService();
        quizService.quizDao = quizDao;
        quizService.quizInterface = quizInterface;

        // Create a mock Quiz object
        Quiz mockQuiz = new Quiz();
        mockQuiz.setId(1);
        mockQuiz.setTitle("Sample Quiz");
        mockQuiz.setQuestions(Arrays.asList(101, 102, 103));

        // Mocking the behavior of quizDao.findById()
        when(quizDao.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.of(mockQuiz));

        // Mocking the behavior of quizInterface.getQuestionsFromId()
        List<QuestionWrapper> mockQuestions = Arrays.asList(
                new QuestionWrapper(101, "Question 1", "Option A", "Option B", "Option C", "Option D"),
                new QuestionWrapper(102, "Question 2", "Option A", "Option B", "Option C", "Option D"),
                new QuestionWrapper(103, "Question 3", "Option A", "Option B", "Option C", "Option D")
        );
        when(quizInterface.getQuestionsFromId(ArgumentMatchers.anyList()))
                .thenReturn(new ResponseEntity<>(mockQuestions, HttpStatus.OK));

        // Call the service method
        ResponseEntity<List<QuestionWrapper>> response = quizService.getQuizQuestions(1);

        // Assertions
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(3, response.getBody().size());
        assertEquals(101, response.getBody().get(0).getId());
        assertEquals("Question 1", response.getBody().get(0).getQuestionTitle());
        assertEquals("Option A", response.getBody().get(0).getOption1());

        // Verify the interactions
        verify(quizDao, times(1)).findById(ArgumentMatchers.anyInt());
        verify(quizInterface, times(1)).getQuestionsFromId(ArgumentMatchers.anyList());
    }
}