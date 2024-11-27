package br.com.juhmaran.customer.core.validation;

import br.com.juhmaran.customer.core.validation.annotations.ValidPhone;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PhoneValidator implements ConstraintValidator<ValidPhone, String> {

    private static final String PHONE_REGEX = "^\\+?\\d{9,14}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) {
            log.warn("Validation failed: phone number is null or blank");
            return false;
        }
        boolean isValid = value.matches(PHONE_REGEX);
        if (isValid) {
            log.info("Validation succeeded: phone number is valid");
        } else {
            log.warn("Validation failed: phone number does not match the regex");
        }
        return isValid;
    }

}
