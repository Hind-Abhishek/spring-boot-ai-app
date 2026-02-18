package com.abhishek.ai.service;

import com.abhishek.ai.dto.AiRequest;
import com.abhishek.ai.dto.AiResponse;

public interface AiService {
    AiResponse askQuestion(AiRequest request);
}