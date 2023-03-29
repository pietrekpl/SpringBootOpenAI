package com.example.springbootopenai.whisper.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

public class FileSizeValidator implements ConstraintValidator<ValidFileSize, MultipartFile> {

    public static final Integer MAX_FILE_SIZE = 25_000_000;

    @Override
    public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
        return value.getSize() < MAX_FILE_SIZE;
    }
}
