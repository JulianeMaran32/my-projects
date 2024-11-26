package br.com.juhmaran.customer.core.validation;

import br.com.juhmaran.customer.core.validation.annotations.NotEmptyNotNullNotBlank;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotEmptyNotNullNotBlankValidator implements ConstraintValidator<NotEmptyNotNullNotBlank, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.debug("Starting validation: {}", value);

        if (value == null) {
            log.warn("Validation failed: value is null");
            return false;
        }

        if (value.trim().isEmpty()) {
            log.warn("Validation failed: value is empty or blank");
            return false;
        }

        log.info("Validation succeeded: value is not null, empty, or blank");
        return true;
    }
}