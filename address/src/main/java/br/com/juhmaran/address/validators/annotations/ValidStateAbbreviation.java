package br.com.juhmaran.address.validators.annotations;

import br.com.juhmaran.address.validators.StateAbbreviationValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StateAbbreviationValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidStateAbbreviation {

    String message() default "A abreviação do estado deve conter exatamente 2 letras maiúsculas.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}