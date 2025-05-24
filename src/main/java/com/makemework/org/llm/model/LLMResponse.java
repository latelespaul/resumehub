package com.makemework.org.llm.model;

public class LLMResponse {
    private String text;
    private double confidence;
    
    public LLMResponse() {}
    
    public LLMResponse(String text, double confidence) {
        this.text = text;
        this.confidence = confidence;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public double getConfidence() {
        return confidence;
    }
    
    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }
}
