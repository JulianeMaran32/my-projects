package br.com.juhmaran.customer.core.validation;

import br.com.juhmaran.customer.core.validation.annotations.ValidCpf;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

public class ValidCpfValidator implements ConstraintValidator<ValidCpf, String> {

    private final CPFValidator cpfValidator = new CPFValidator();

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            return false;
        }

        String cpfSemMascara = value.replaceAll("\\D", "");

        cpfValidator.initialize(null);
        return cpfValidator.isValid(cpfSemMascara, context);
    }

}
