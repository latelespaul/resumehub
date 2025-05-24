package com.makemework.org.llm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.makemework.org.llm.model.LLMResponse;
import com.makemework.org.llm.service.LLMService;

@RestController
@RequestMapping("/api/llm")
public class LLMController {
    
    private final LLMService llmService;
    
    public LLMController(LLMService llmService) {
        this.llmService = llmService;
    }
    
    @PostMapping("/analyze")
    public ResponseEntity<LLMResponse> analyzeText(@RequestBody String text) {
        LLMResponse response = llmService.analyzeText(text);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/generate")
    public ResponseEntity<LLMResponse> generateResponse(@RequestBody String prompt) {
        LLMResponse response = llmService.generateResponse(prompt);
        return ResponseEntity.ok(response);
    }
}
