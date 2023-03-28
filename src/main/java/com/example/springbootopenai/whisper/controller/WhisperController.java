package com.example.springbootopenai.whisper.controller;

import com.example.springbootopenai.whisper.model.WhisperResponse;
import com.example.springbootopenai.whisper.model.WhisperUserRequest;
import com.example.springbootopenai.whisper.service.WhisperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class WhisperController {

    private final WhisperService whisperService;

    @PostMapping("/transcription")
    public WhisperResponse createTranscription(@ModelAttribute WhisperUserRequest whisperUserRequest) {
        log.info("Request:  {}", whisperUserRequest);
        log.info("{}",whisperService.createTranscription(whisperUserRequest));
        return whisperService.createTranscription(whisperUserRequest);
    }

    @PostMapping("/translation")
    public WhisperResponse createTranslation(@ModelAttribute WhisperUserRequest whisperUserRequest) {
        log.info("Request:  {}", whisperUserRequest);
        log.info("{}",whisperService.createTranslation(whisperUserRequest));
        return whisperService.createTranslation(whisperUserRequest);
    }

}
