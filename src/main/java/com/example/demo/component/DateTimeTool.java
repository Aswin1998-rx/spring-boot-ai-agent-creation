package com.example.demo.component;

import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// tools/DateTimeTool.java
@Component
public class DateTimeTool {

    @Tool("Returns the current date and time. Use when user asks about current time or date.")
    public String getCurrentDateTime() {
        return "Current date and time: " + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}