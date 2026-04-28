package com.example.demo.component;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.ollama.OllamaChatModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ReactAgent {

    private final OllamaChatModel chatModel;
    private final CalculatorTool calculatorTool;
    private final WeatherTool weatherTool;
    private final DateTimeTool dateTimeTool;

    private static final String REACT_SYSTEM_PROMPT = """
        You are a helpful AI assistant with access to the following tools:
        
        1. calculator(expression: string) - Evaluates math expressions like "10 * 5 + 3"
        2. get_weather(city: string) - Gets current weather for a city
        3. get_datetime() - Returns the current date and time
        
        To use a tool, respond EXACTLY in this format:
        TOOL: tool_name
        INPUT: tool_input
        
        After receiving the tool result, continue reasoning and give a final answer.
        If no tool is needed, respond 'sorry i am not aware of it'.
        
        Examples:
        User: What is 25 * 4?
        TOOL: calculator
        INPUT: 25 * 4
        
        User: What's the weather in Mumbai?
        TOOL: get_weather
        INPUT: Mumbai
        
        User: date today?
        TOOL: get_datetime?
        """;



    public String chat(String userMessage) {
        List<ChatMessage> messages = new ArrayList<>();
        messages.add(new SystemMessage(REACT_SYSTEM_PROMPT));
        messages.add(new UserMessage(userMessage));

        // ReAct loop — max 5 iterations
        for (int i = 0; i < 5; i++) {
            AiMessage aiResponse = chatModel.generate(messages).content();
            String responseText = aiResponse.text();
            messages.add(aiResponse);

            // Check if model wants to use a tool
            if (responseText.contains("TOOL:") || responseText.contains("INPUT:")) {
                String toolResult = executeTool(responseText);

                // Feed tool result back as a user message
                messages.add(new UserMessage("Tool result: " + toolResult +
                        "\nNow give your final answer to the user."));
            } else {
                // No tool call — this is the final answer
                return responseText;
            }
        }

        return "I was unable to complete the task after multiple attempts.";
    }

    private String executeTool(String response) {
        try {
            String toolName = extractBetween(response, "TOOL:", "\n").trim();
            String toolInput = extractBetween(response, "INPUT:", "\n").trim();

            return switch (toolName.toLowerCase()) {
                case "calculator"    -> String.valueOf(calculatorTool.calculate(toolInput));
                case "get_weather"   -> weatherTool.getWeather(toolInput);
                case "get_datetime"  -> dateTimeTool.getCurrentDateTime();
                default              -> "Unknown tool: " + toolName;
            };
        } catch (Exception e) {
            return "Tool execution failed: " + e.getMessage();
        }
    }

    private String extractBetween(String text, String startMarker, String endMarker) {
        int start = text.indexOf(startMarker);
        if (start == -1) return "";
        start += startMarker.length();
        int end = text.indexOf(endMarker, start);
        return end == -1 ? text.substring(start) : text.substring(start, end);
    }
}