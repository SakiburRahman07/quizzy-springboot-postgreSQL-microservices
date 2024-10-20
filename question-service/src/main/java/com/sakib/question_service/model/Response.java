package com.sakib.question_service.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {
    public Integer getId() {
        return id;
    }

    public String getResponse() {
        return response;
    }

    private Integer id;
    private String response;
}
