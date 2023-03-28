package com.example.springbootopenai.whisper.config;

import feign.RequestInterceptor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class WhisperConfiguration {

    @Value("${openai.base.api-key}")
    private String apiKey;

    @Value("${openai.whisper.audio-model}")
    private String audioModel;

    @Bean
    public RequestInterceptor apiInterceptor() {
        return template -> template.header("Authorization", "Bearer " + apiKey);
    }
}
