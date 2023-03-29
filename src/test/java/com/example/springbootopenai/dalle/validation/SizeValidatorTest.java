package com.example.springbootopenai.dalle.validation;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class SizeValidatorTest {

    @InjectMocks
    ConstraintValidatorContext constraintValidatorContext;

    SizeValidator validator;

    @BeforeEach
    public void setUp() {
         validator = new SizeValidator();
    }

    @Test
    void isValidSizeFromList() {
        //When
        boolean validSize512 = validator.isValid("512x512", constraintValidatorContext);
        //Then
        assertTrue(validSize512);
    }

    @Test
    void isNotValidOutsideListValues() {
        //When
        boolean notValidSize128 = validator.isValid("128x128", constraintValidatorContext);
        //Then
        assertFalse(notValidSize128);
    }
    @Test
    void isNotValidEmptyValue() {
        //When
        boolean notValidEmptyValue= validator.isValid("", constraintValidatorContext);
        //Then
        assertFalse(notValidEmptyValue);
    }




}