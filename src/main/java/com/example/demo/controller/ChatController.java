package com.example.demo.controller;

import com.example.demo.component.ReactAgent;
import com.example.demo.server.model.ChatRequest;
import com.example.demo.service.student.ai.AiService;
import com.example.demo.service.student.ai.AssistantAgent;
import com.example.demo.service.student.ai.MultiSessionAgent;
import dev.langchain4j.model.chat.response.ChatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {
    private final AiService aiService;
    private final AssistantAgent assistantAgent;
    private final ReactAgent reactAgent;

    private final MultiSessionAgent multiSessionAgent;
    @PostMapping()
    public String chat(ChatRequest request) {
        String response = reactAgent.chat(request.getMessage());
        return response;
    }
}
