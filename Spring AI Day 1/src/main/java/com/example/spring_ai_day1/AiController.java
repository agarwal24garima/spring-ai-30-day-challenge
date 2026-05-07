package com.example.spring_ai_day1;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class AiController {

    private final ChatClient chatClient;

    public AiController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @PostMapping("/chat")
    public String chat(@RequestBody String question) {
        return chatClient.prompt()
                .user(question)
                .call()
                .content();
    }
}