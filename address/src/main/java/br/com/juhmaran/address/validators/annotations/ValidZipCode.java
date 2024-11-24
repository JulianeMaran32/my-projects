package br.com.juhmaran.address.validators.annotations;

import br.com.juhmaran.address.validators.ZipCodeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {ZipCodeValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidZipCode {

    String message() default "CEP inválido. Deve conter exatamente 8 dígitos numéricos.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
