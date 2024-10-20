package com.sakib.quizzy.dao;

import com.sakib.quizzy.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
