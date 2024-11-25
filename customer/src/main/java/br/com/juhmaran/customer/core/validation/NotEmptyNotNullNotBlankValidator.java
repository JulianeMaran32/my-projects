package br.com.juhmaran.customer.core.validation;

import br.com.juhmaran.customer.core.validation.annotations.NotEmptyNotNullNotBlank;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotEmptyNotNullNotBlankValidator implements ConstraintValidator<NotEmptyNotNullNotBlank, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !value.trim().isEmpty();
    }

}