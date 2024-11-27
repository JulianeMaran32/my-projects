package br.com.juhmaran.customer.core.validation;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhoneValidatorTest {

    private final PhoneValidator validator = new PhoneValidator();

    @Test
    @DisplayName("Should return false for null phone")
    void shouldReturnFalseForNullPhone() {
        boolean resultado = validator.isValid(null, Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertFalse(resultado);
    }

    @Test
    @DisplayName("Should return false for empty phone")
    void shouldReturnFalseForEmptyPhone() {
        boolean resultado = validator.isValid("", Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertFalse(resultado);
    }

    @Test
    @DisplayName("Should return false for blank phone")
    void shouldReturnFalseForTooShortPhone() {
        String telefoneCurto = "12345678";
        boolean resultado = validator.isValid(telefoneCurto, Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertFalse(resultado);
    }

    @Test
    @DisplayName("Should return false for too long phone")
    void shouldReturnFalseForTooLongPhone() {
        String telefoneLongo = "123456789012345";
        boolean resultado = validator.isValid(telefoneLongo, Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertFalse(resultado);
    }

    @Test
    @DisplayName("Should return true for valid phone without plus")
    void shouldReturnTrueForValidPhoneWithoutPlus() {
        String telefoneValido = "123456789";
        boolean resultado = validator.isValid(telefoneValido, Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertTrue(resultado);
    }

    @Test
    @DisplayName("Should return true for valid phone with plus")
    void shouldReturnTrueForValidPhoneWithPlus() {
        String telefoneValidoComPlus = "+1234567890123";
        boolean resultado = validator.isValid(telefoneValidoComPlus, Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertTrue(resultado);
    }

}