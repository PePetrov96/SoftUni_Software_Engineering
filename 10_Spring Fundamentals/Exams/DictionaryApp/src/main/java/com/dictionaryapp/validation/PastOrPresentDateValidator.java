package com.dictionaryapp.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class PastOrPresentDateValidator implements ConstraintValidator<PastOrPresentDateOnly, LocalDate> {

    @Override
    public void initialize(PastOrPresentDateOnly constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        return localDate != null && !localDate.isAfter(LocalDate.now());
    }
}