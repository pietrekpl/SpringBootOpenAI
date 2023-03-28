package com.example.springbootopenai.dalle.service;

import com.example.springbootopenai.dalle.model.GenerateImageRequest;
import com.example.springbootopenai.dalle.model.GenerateImageResponse;

public interface ImageGeneratorService {

    GenerateImageResponse generateImage(GenerateImageRequest generateImageRequest);

}
