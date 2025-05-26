package com.nostratech.belajar_springboot.validation;

import com.nostratech.belajar_springboot.validation.annotation.ValidName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<ValidName, String> {

    @Override
    public void initialize(ValidName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if(name.equalsIgnoreCase("admin"))
            return false;
        return true;
    }
}
