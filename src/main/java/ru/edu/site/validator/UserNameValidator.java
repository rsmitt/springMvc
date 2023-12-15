package ru.edu.site.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserNameValidator implements ConstraintValidator<UserNameConstraint, String> {

    private String[] blackList = {"Anton", "Petr"};

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        for(String name: blackList) {
            if (s.equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }
}
