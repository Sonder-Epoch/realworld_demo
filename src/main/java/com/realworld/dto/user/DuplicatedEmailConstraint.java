package com.realworld.dto.user;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DuplicatedEmailValidator.class)
public @interface DuplicatedEmailConstraint {
    String message() default "duplicated email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
