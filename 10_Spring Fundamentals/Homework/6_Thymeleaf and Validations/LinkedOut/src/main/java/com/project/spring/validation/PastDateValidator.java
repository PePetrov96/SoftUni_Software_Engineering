package com.project.spring.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class PastDateValidator implements ConstraintValidator<PastDate, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            return false;
        }

        LocalDate birthdate;

        try {
            birthdate = LocalDate.parse(value);
        } catch (Exception e) {
            return false;
        }

        return birthdate.isBefore(LocalDate.now());
    }
}