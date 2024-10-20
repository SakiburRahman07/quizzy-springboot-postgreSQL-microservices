package com.sakib.question_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
    //SELECT setval('question_id_seq', (SELECT MAX(id) FROM question));
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questiontitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public Integer getId() {
        return id;
    }

    public String getQuestiontitle() {
        return questiontitle;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public String getDifficultylevel() {
        return difficultylevel;
    }

    public String getCategory() {
        return category;
    }

    private String rightAnswer;
    private String difficultylevel;
    private String category;



}
