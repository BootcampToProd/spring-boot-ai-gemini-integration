package com.bootcamptoprod.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {


    @Bean(name = "chatClientWithToolsSupport")
    public ChatClient chatClientWithToolsSupport(ChatClient.Builder chatClientBuilder, ToolCallbackProvider tools) {
        return chatClientBuilder.defaultTools(tools).build();
    }

    @Bean(name = "chatClientWithoutToolsSupport")
    public ChatClient chatClientWithoutToolsSupport(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder.build();
    }
}
