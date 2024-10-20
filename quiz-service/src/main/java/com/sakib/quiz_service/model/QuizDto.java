package com.sakib.quiz_service.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuizDto {
    String categoryName;
    Integer numQuestions;
    String title;

    public String getCategoryName() {
        return categoryName;
    }

    public Integer getNumQuestions() {
        return numQuestions;
    }

    public String getTitle() {
        return title;
    }
}
