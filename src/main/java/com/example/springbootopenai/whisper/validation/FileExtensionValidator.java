package com.example.springbootopenai.whisper.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
public class FileExtensionValidator implements ConstraintValidator<ValidFileExtension, MultipartFile> {


    private final static List<String> ALLOWED_FILE_EXTENSIONS = Arrays.asList("mp3", "mp4", "mpeg", "mpga", "m4a", "wav", "webm");


    @Override
    public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {

        boolean endsWith = false;
        for (String extension : ALLOWED_FILE_EXTENSIONS) {
            if (Objects.requireNonNull(value.getOriginalFilename()).endsWith(extension)) {
                endsWith = true;
            }
        }
        return endsWith;
    }
}
