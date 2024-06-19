package com.bonappetit.vallidation;

import com.bonappetit.model.dto.UserRegisterDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserRegisterDTO> {
    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(final UserRegisterDTO user,
                           final ConstraintValidatorContext context) {

        // Handle the error here
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            context.disableDefaultConstraintViolation(); // disable the error on the global level.

            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("confirmPassword").addConstraintViolation(); // assign the error to confirmPassword field.
            return false;
        }

        return true;
    }
}