package com.example.springbootopenai.whisper.validation;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class FileSizeValidatorTest {

    @InjectMocks
    private FileSizeValidator fileSizeValidator;

    @Mock
    private ConstraintValidatorContext constraintValidatorContext;



    @Test
    public void testValidFileSize() {
        // Given
        byte[] fileContent = new byte[24_999_999];
        MockMultipartFile file = new MockMultipartFile("file", "file.mp3", "multipart/form-data", fileContent);

        // When
        boolean result = fileSizeValidator.isValid(file, constraintValidatorContext);

        // Then
        assertTrue(result);
    }
    @Test
    public void testInvalidValidFileSize() {
        // Given
        byte[] fileContent = new byte[25_000_001];
        MockMultipartFile file = new MockMultipartFile("file", "file.mp3", "multipart/form-data", fileContent);

        // When
        boolean result = fileSizeValidator.isValid(file, constraintValidatorContext);

        // Then
        assertFalse(result);
    }
}