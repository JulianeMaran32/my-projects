package br.com.juhmaran.customer.core.validation.annotations;

import br.com.juhmaran.customer.core.validation.ValidCpfValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ValidCpfValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCpf {

    String message() default "CPF inválido. Deve ser no formato válido com ou sem máscara.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
