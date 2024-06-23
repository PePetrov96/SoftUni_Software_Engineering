package com.dictionaryapp.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IncorrectCredentialsValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IncorrectCredentials {
    String message() default "Incorrect username or password!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}