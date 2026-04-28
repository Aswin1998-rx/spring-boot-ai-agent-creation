package com.example.demo.config;

import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.Duration;

// config/LlmConfig.java
@Configuration
public class LlmConfig {

    @Value("${ollama.base-url}")
    private String baseUrl;

    @Value("${ollama.model}")
    private String model;

    @Bean
    public OllamaChatModel ollamaChatModel() {
        return OllamaChatModel.builder()
                .baseUrl(baseUrl)
                .modelName(model)
                .temperature(0.7)
                .timeout(Duration.ofSeconds(120))
                .build();

    }

    // In-memory chat memory (per session)
    @Bean
    public ChatMemoryStore chatMemoryStore() {
        return new InMemoryChatMemoryStore();
    }
}