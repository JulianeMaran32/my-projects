package br.com.juhmaran.address.validators;

import br.com.juhmaran.address.validators.annotations.ValidZipCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ZipCodeValidator implements ConstraintValidator<ValidZipCode, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return false;
        }
        return value.matches("^\\d{8}$");
    }

}
