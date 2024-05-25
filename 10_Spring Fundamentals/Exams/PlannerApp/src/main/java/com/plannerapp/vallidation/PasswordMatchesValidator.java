package com.plannerapp.vallidation;

import com.plannerapp.model.dto.UserRegisterBindingModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserRegisterBindingModel> {
    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
    }

//    @Override
//    public boolean isValid(final UserRegisterBinding user, final ConstraintValidatorContext context) {
//        return user.getPassword().equals(user.getConfirmPassword());
//    }
    @Override
    public boolean isValid(final UserRegisterBindingModel user,
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
