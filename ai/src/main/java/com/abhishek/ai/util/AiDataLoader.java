package com.abhishek.ai.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class AiDataLoader {

    private List<Map<String, String>> qaList = new ArrayList<>();

    @Autowired
    public void loadQaData() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ClassPathResource resource = new ClassPathResource("qa_data.json");
            Map<String, Object> data = objectMapper.readValue(resource.getInputStream(), Map.class);
            qaList = (List<Map<String, String>>) data.get("qaData");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String findAnswer(String question) {
        if (qaList.isEmpty()) {
            loadQaData();
        }

        String lowerQuestion = question.toLowerCase().trim();

        for (Map<String, String> qa : qaList) {
            String key = qa.get("question").toLowerCase();
            if (key.contains(lowerQuestion) || lowerQuestion.contains(key)) {
                return qa.get("answer");
            }
        }

        return "Sorry, I don't have an answer for that question. Please try another question.";
    }

    public List<Map<String, String>> getAllQaData() {
        if (qaList.isEmpty()) {
            loadQaData();
        }
        return qaList;
    }
}