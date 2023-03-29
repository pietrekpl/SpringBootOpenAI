package com.example.springbootopenai.whisper.model;

import com.example.springbootopenai.whisper.validation.ValidFileSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class WhisperUserRequest implements Serializable {

    @ValidFileSize
    private MultipartFile file;
}
