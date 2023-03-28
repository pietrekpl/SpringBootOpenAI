package com.example.springbootopenai.chatGpt.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class OpenAIChatConfiguration {
    @Value("${openai.base.api-key}")
    private String apiKey;

    @Value("${openai.chat.authorization}")
    private String authorization;

    @Value("${openai.chat.bearer}")
    private String bearer;

    @Value("${openai.chat.chat-model}")
    private String chatModel;

    @Value("${openai.chat.chat-full-path-url}")
    private String url;

    @Value("${openai.chat.media-type}")
    private String mediaType;

    @Value("${openai.chat.max-tokens}")
    private Integer maxTokens;

    @Value("${openai.chat.temperature}")
    private Double temperate;

    @Value("${openai.chat.top-p}")
    private Double topP;

}
