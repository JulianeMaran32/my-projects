package br.com.juhmaran.customer.core.validation.annotations;

import br.com.juhmaran.customer.core.validation.PhoneValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhone {

    String message() default "The phone number must be valid and have between 9 and 14 digits, with an optional '+'.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
