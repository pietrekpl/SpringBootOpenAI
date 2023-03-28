package com.example.springbootopenai.whisper.model;

import com.example.springbootopenai.whisper.config.WhisperConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "whisper-service",
        url = "${openai.base.url}",
        configuration = WhisperConfiguration.class
)
public interface OpenAiWhisperClient {

    @PostMapping(value = "${openai.whisper.create-transcription-url}", headers = {"Content-Type=multipart/form-data"})
    WhisperResponse createTranscription(@ModelAttribute WhisperRequest whisperRequest);

    @PostMapping(value = "${openai.whisper.create-translation-url}", headers = {"Content-Type=multipart/form-data"})
    WhisperResponse createTranslation(@ModelAttribute WhisperRequest whisperRequest);


}
