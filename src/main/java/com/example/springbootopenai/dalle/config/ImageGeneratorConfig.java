package com.example.springbootopenai.dalle.config;

import com.example.springbootopenai.dalle.model.GenerateImageRequest;
import com.example.springbootopenai.dalle.model.GenerateImageResponse;
import com.example.springbootopenai.dalle.model.ImageGeneratorClient;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImageGeneratorConfig {

    @Value("${openai.base.api-key}")
    private String apiKey;

    @Bean
    public RequestInterceptor apiKeyInterceptor() {
        return template -> template.header("Authorization", "Bearer " + apiKey);
    }

}
