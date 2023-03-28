package com.example.springbootopenai.whisper.service;

import com.example.springbootopenai.whisper.config.WhisperConfiguration;
import com.example.springbootopenai.whisper.model.OpenAiWhisperClient;
import com.example.springbootopenai.whisper.model.WhisperRequest;
import com.example.springbootopenai.whisper.model.WhisperResponse;
import com.example.springbootopenai.whisper.model.WhisperUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WhisperServiceImpl implements WhisperService {

    private final OpenAiWhisperClient whisperClient;
    private final WhisperConfiguration whisperConfiguration;

    private WhisperRequest getWhisperRequest(WhisperUserRequest whisperUserRequest) {
        WhisperRequest whisperRequest = WhisperRequest.builder()
                .model(whisperConfiguration.getAudioModel())
                .file(whisperUserRequest.getFile())
                .build();
        return whisperRequest;
    }

    @Override
    public WhisperResponse createTranscription(WhisperUserRequest whisperUserRequest) {
        WhisperRequest whisperRequest = getWhisperRequest(whisperUserRequest);
        return whisperClient.createTranscription(whisperRequest);
    }

    @Override
    public WhisperResponse createTranslation(WhisperUserRequest whisperUserRequest) {
        WhisperRequest whisperRequest = getWhisperRequest(whisperUserRequest);
        return whisperClient.createTranslation(whisperRequest);
    }
}