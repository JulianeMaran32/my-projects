package br.com.juhmaran.customer.core.validation.annotations;

import br.com.juhmaran.customer.core.validation.NotEmptyNotNullNotBlankValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NotEmptyNotNullNotBlankValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmptyNotNullNotBlank {

    String message() default "O campo não pode ser nulo, vazio ou conter apenas espaços em branco";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
