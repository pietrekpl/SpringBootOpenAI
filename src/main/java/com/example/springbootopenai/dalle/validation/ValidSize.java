package com.example.springbootopenai.dalle.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SizeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSize {

    String message() default "Invalid value. Available sizes are : 256x256, 512x512 or 1024x1024.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
