package com.example.demo.service.student.ai;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;

// agent/MultiSessionAgent.java
public interface MultiSessionAgent {
    String chat(@MemoryId String sessionId, @UserMessage String userMessage);
}