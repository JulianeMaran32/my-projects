package br.com.juhmaran.address.validators;

import br.com.juhmaran.address.validators.annotations.ValidStateAbbreviation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StateAbbreviationValidator implements ConstraintValidator<ValidStateAbbreviation, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return false;
        }
        return value.matches("^[A-Z]{2}$");
    }

}
