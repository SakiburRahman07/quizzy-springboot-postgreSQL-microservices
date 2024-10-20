package com.sakib.quiz_service.service;


import com.sakib.quiz_service.dao.QuizDao;
import com.sakib.quiz_service.model.QuestionWrapper;
import com.sakib.quiz_service.model.Quiz;
import com.sakib.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
//    @Autowired
//    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        RestTemplate


        List<Integer> questions = // call the generate url
//        Quiz quiz = new Quiz();
//        quiz.setTitle(title);
//        quiz.setQuestions(questions);
//        quizDao.save(quiz);

return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
//      Optional<Quiz> quiz = quizDao.findById(id);
//      List<Question> questionFromDB = quiz.get().getQuestions();
    List<QuestionWrapper> questionForUser = new ArrayList<>();
//      for(Question q : questionFromDB)
//      {
//          QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestiontitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4() );
//          questionForUser.add(qw);
//      }
      return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).orElse(null);
        if (quiz == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

//        List<Question> questions = quiz.getQuestions();
        int right = 0;
//
//        int numberOfQuestions = Math.min(responses.size(), questions.size());
//
//        for (int i = 0; i < numberOfQuestions; i++) {
//            Response response = responses.get(i);
//            if (response.getResponse().equals(questions.get(i).getRightAnswer())) {
//                right++;
//            }
//        }

        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
