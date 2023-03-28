package com.example.springbootopenai.whisper.service;

import com.example.springbootopenai.whisper.model.WhisperResponse;
import com.example.springbootopenai.whisper.model.WhisperUserRequest;

public interface WhisperService {

    WhisperResponse createTranscription(WhisperUserRequest whisperUserRequest);

    WhisperResponse createTranslation(WhisperUserRequest whisperUserRequest);
}
