package com.example.demo.service.student.ai;

import com.example.demo.component.CalculatorTool;
import com.example.demo.component.DateTimeTool;
import com.example.demo.component.WeatherTool;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// agent/AgentFactory.java
@Configuration
public class AgentFactory {

    @Bean
    public AssistantAgent assistantAgent(
            OllamaChatModel chatModel,
            CalculatorTool calculatorTool,
            WeatherTool weatherTool,
            DateTimeTool dateTimeTool) {

        return AiServices.builder(AssistantAgent.class)
                .chatLanguageModel(chatModel)
                .tools(calculatorTool, weatherTool, dateTimeTool)  // register tools
                .chatMemory(MessageWindowChatMemory.withMaxMessages(20)) // sliding window memory
                .systemMessageProvider(memoryId ->
                        "You are a helpful AI assistant. You have access to tools. " +
                                "Use them when needed. Be concise and accurate.")
                .build();
    }
}