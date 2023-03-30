package com.example.springbootopenai.dalle.controller;

import com.example.springbootopenai.dalle.model.GenerateImageRequest;
import com.example.springbootopenai.dalle.model.GenerateImageResponse;
import com.example.springbootopenai.dalle.service.ImageGeneratorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
@AllArgsConstructor
public class ImageGeneratorController {

    private final ImageGeneratorService imageGeneratorService;

    @PostMapping("/generate")
    public ResponseEntity<GenerateImageResponse> generateImage(@Valid @RequestBody final GenerateImageRequest request) {
        final GenerateImageResponse response = imageGeneratorService.generateImage(request);
        log.info("Generated Image : {}", response.getData());
        return ResponseEntity.ok(response);
    }

}
