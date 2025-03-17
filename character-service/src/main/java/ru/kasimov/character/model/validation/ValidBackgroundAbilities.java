package ru.kasimov.character.model.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidBackgroundAbilitiesValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidBackgroundAbilities {

    String message() default "Background modifier can only be applied to abilities allowed by the background";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
