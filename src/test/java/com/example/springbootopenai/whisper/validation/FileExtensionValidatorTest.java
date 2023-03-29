package com.example.springbootopenai.whisper.validation;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.mock.web.MockMultipartFile;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileExtensionValidatorTest {

    private final static List<String> ALLOWED_FILE_EXTENSIONS = Arrays.asList(".mp3", ".mp4", ".mpeg", ".mpga", ".m4a", ".wav", ".webm");
    private final FileExtensionValidator fileExtensionValidator = new FileExtensionValidator();
    private final ConstraintValidatorContext constraintValidatorContext = Mockito.mock(ConstraintValidatorContext.class);

    @Test
    public void testValidFileExtension() {
        MockMultipartFile mockFile = new MockMultipartFile("test.mp3", new byte[0]);
        assertTrue(fileExtensionValidator.isValid(mockFile, constraintValidatorContext));
    }

    @Test
    public void testInvalidFileExtension() {
        MockMultipartFile mockFile = new MockMultipartFile("test.pdf", new byte[0]);
        assertFalse(fileExtensionValidator.isValid(mockFile, constraintValidatorContext));
    }


}