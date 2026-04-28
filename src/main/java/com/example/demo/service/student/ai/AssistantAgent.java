package com.example.demo.service.student.ai;

// agent/AssistantAgent.java
public interface AssistantAgent {

    /**
     * Single-turn (no memory)
     */
    String chat(String userMessage);
}
