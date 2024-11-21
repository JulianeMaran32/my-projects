package br.com.juhmaran.address.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CepValidator implements ConstraintValidator<ValidCep, String> {

    private static final String CEP_REGEX = "^\\d{5}-?\\d{3}$";

    @Override
    public void initialize(ValidCep constraintAnnotation) {
    }

    @Override
    public boolean isValid(String cep, ConstraintValidatorContext context) {
        if (cep == null) {
            return false;
        }
        return cep.matches(CEP_REGEX);
    }
}
