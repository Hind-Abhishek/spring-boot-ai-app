package com.abhishek.ai.service;

import com.abhishek.ai.dto.AiRequest;
import com.abhishek.ai.dto.AiResponse;
import com.abhishek.ai.util.AiDataLoader;
import org.springframework.stereotype.Service;

@Service
public class AiServiceImpl implements AiService {

    private final AiDataLoader aiDataLoader;

    public AiServiceImpl(AiDataLoader aiDataLoader) {
        this.aiDataLoader = aiDataLoader;
    }

    @Override
    public AiResponse askQuestion(AiRequest request) {
        String question = request.getQuestion();
        String answer = aiDataLoader.findAnswer(question);
        return new AiResponse(question, answer);
    }
}