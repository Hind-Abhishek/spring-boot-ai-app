package com.abhishek.ai.dto;

import jakarta.validation.constraints.NotBlank;

public class AiRequest {

    @NotBlank(message = "Question must not be empty")
    private String question;

    public AiRequest() {
    }

    public AiRequest(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}