package com.example.springbootopenai.whisper.validation;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileExtensionValidatorTest {

    private final FileExtensionValidator validator = new FileExtensionValidator();

    @Test
    void isValid_withValidFileExtension_returnsTrue() {
        // Arrange
        String fileName = "test.mp3";
        byte[] content = new byte[] { 0x00 };
        MockMultipartFile file = new MockMultipartFile(fileName, fileName, "audio/mpeg", content);

        // Act
        boolean isValid = validator.isValid(file, null);

        // Assert
        assertTrue(isValid);
    }

    @Test
    void isValid_withInvalidFileExtension_returnsFalse() {
        // Arrange
        String fileName = "test.txt";
        byte[] content = new byte[] { 0x00 };
        MockMultipartFile file = new MockMultipartFile(fileName, fileName, "text/plain", content);

        // Act
        boolean isValid = validator.isValid(file, null);

        // Assert
        assertFalse(isValid);
    }


}