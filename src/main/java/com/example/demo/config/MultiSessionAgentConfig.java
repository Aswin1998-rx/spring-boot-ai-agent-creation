package com.example.demo.config;

import com.example.demo.component.CalculatorTool;
import com.example.demo.component.DateTimeTool;
import com.example.demo.component.WeatherTool;
import com.example.demo.service.student.ai.MultiSessionAgent;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// config/MultiSessionAgentConfig.java
@Configuration
public class MultiSessionAgentConfig {

    @Bean
    public MultiSessionAgent multiSessionAgent(
            OllamaChatModel chatModel,
            ChatMemoryStore memoryStore,
            CalculatorTool calculatorTool,
            WeatherTool weatherTool,
            DateTimeTool dateTimeTool) {

        return AiServices.builder(MultiSessionAgent.class)
                .chatLanguageModel(chatModel)
                .tools(calculatorTool, weatherTool, dateTimeTool)
                .chatMemoryProvider(sessionId ->
                        MessageWindowChatMemory.builder()
                                .id(sessionId)
                                .maxMessages(20)
                                .chatMemoryStore(memoryStore)
                                .build())
                .build();
    }
}
