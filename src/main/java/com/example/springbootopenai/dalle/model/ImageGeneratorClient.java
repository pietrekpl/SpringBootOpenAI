package com.example.springbootopenai.dalle.model;

import com.example.springbootopenai.dalle.config.ImageGeneratorConfig;
import lombok.Data;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ImageGeneratorClient", url = "${openai.base.url}", configuration = ImageGeneratorConfig.class)
public interface ImageGeneratorClient {

    @PostMapping(value = "/v1/images/generations")
    GenerateImageResponse generateImage(@RequestBody final GenerateImageRequest request);
}
