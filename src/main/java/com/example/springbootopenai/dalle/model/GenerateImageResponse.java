package com.example.springbootopenai.dalle.model;

import lombok.Data;

import java.util.List;

@Data
public class GenerateImageResponse {

    private List<GeneratedImage> data;

}
