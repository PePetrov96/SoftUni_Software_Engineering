package com.plannerapp.vallidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class FutureDateValidator implements ConstraintValidator<FutureDateOnly, LocalDate> {

    @Override
    public void initialize(FutureDateOnly constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        return localDate != null && !localDate.isBefore(LocalDate.now().plusDays(1));
    }
}
