package com.makemework.org.llm.service;

import com.makemework.org.llm.model.LLMResponse;

public interface LLMService {
    LLMResponse analyzeText(String text);
    LLMResponse generateResponse(String prompt);
}
