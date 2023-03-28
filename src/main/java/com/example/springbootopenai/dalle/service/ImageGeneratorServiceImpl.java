package com.example.springbootopenai.dalle.service;

import com.example.springbootopenai.dalle.model.GenerateImageRequest;
import com.example.springbootopenai.dalle.model.GenerateImageResponse;
import com.example.springbootopenai.dalle.model.ImageGeneratorClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageGeneratorServiceImpl implements  ImageGeneratorService{

    private ImageGeneratorClient imageGeneratorClient;

    @Override
    public GenerateImageResponse generateImage(final GenerateImageRequest generateImageRequest) {
        final  GenerateImageResponse response = imageGeneratorClient.generateImage(generateImageRequest);
        return response;
    }
}
