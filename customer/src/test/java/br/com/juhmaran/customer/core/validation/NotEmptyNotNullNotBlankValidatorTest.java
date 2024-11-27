package br.com.juhmaran.customer.core.validation;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NotEmptyNotNullNotBlankValidatorTest {

    private final NotEmptyNotNullNotBlankValidator validator = new NotEmptyNotNullNotBlankValidator();

    @Test
    @DisplayName("Should return false for null value")
    void shouldReturnFalseForNullValue() {
        boolean resultado = validator.isValid(null, Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertFalse(resultado);
    }

    @Test
    @DisplayName("Should return false for blank value")
    void shouldReturnFalseForBlankValue() {
        boolean resultado = validator.isValid("   ", Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertFalse(resultado);
    }

    @Test
    @DisplayName("Should return true for valid value")
    void shouldReturnTrueForValidValue() {
        boolean resultado = validator.isValid("Valid text", Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertTrue(resultado);
    }

}
