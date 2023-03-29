package com.example.springbootopenai.whisper.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FileExtensionValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidFileExtension {

    String message() default "Invalid file extension. Available formats are : mp3, mp4, mpeg, mpga, m4a, wav, or webm. ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
