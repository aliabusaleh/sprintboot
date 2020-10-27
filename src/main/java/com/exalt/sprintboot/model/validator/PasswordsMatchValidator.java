package com.exalt.sprintboot.model.validator;

import com.exalt.sprintboot.model.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch, User> {
    @Override
    public void initialize(PasswordsMatch constraintAnnotation) {
        return;
    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        return user.getPassword().equals(user.getConfirmPassword());
    }
}
