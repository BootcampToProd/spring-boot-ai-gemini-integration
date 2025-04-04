package com.bootcamptoprod.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mcp")
public class MCPController {

    private final ChatClient chatClientWithToolsSupport;

    public MCPController(ChatClient chatClientWithToolsSupport) {
        this.chatClientWithToolsSupport = chatClientWithToolsSupport;
    }

    @PostMapping("/interact")
    public String interactWithMcp(@RequestBody String userInput) {
        return chatClientWithToolsSupport.prompt(userInput).call().content();
    }
}
