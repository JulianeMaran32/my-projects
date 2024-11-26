package br.com.juhmaran.customer.core.validation;

import br.com.juhmaran.customer.core.validation.annotations.ValidCpf;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

@Slf4j
public class ValidCpfValidator implements ConstraintValidator<ValidCpf, String> {

    private final CPFValidator cpfValidator = new CPFValidator();

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.debug("Starting CPF validation: {}", value);

        if (value == null || value.isBlank()) {
            log.warn("CPF is null or empty");
            return false;
        }

        String cpfSemMascara = value.replaceAll("\\D", "");
        log.debug("CPF without mask: {}", cpfSemMascara);

        cpfValidator.initialize(null);
        boolean isValid = cpfValidator.isValid(cpfSemMascara, context);
        log.debug("CPF validation result: {}", isValid);

        return isValid;
    }

}
