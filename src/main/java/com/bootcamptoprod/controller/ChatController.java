package com.bootcamptoprod.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatClient chatClientWithoutToolsSupport;

    public ChatController(ChatClient chatClientWithoutToolsSupport) {
        this.chatClientWithoutToolsSupport = chatClientWithoutToolsSupport;
    }

    @PostMapping("/ask")
    public String chat(@RequestBody String userInput) {
        return chatClientWithoutToolsSupport.prompt(userInput).call().content();
    }
}
