package com.example.springbootopenai.whisper.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FileSizeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidFileSize {

    String message() default "Invalid file size. Could Take max 25MB";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
