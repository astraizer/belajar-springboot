package com.nostratech.belajar_springboot.validation.annotation;

import com.nostratech.belajar_springboot.validation.NameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = {NameValidator.class})
public @interface ValidName {

    String message() default "Error Name";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
