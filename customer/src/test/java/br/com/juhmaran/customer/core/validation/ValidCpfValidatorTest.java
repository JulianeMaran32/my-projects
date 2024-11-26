package br.com.juhmaran.customer.core.validation;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ValidCpfValidatorTest {

    private final ValidCpfValidator validator = new ValidCpfValidator();

    @Test
    @DisplayName("Should return false for null CPF")
    void shouldReturnFalseForNullCpf() {
        boolean resultado = validator.isValid(null, Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertFalse(resultado);
    }

    @Test
    @DisplayName("Should return false for empty CPF")
    void shouldReturnFalseForInvalidCpf() {
        String cpfInvalido = "12345678900";
        boolean resultado = validator.isValid(cpfInvalido, Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertFalse(resultado);
    }

    @Test
    @DisplayName("Should return true for valid CPF without mask")
    void shouldReturnTrueForValidCpfWithoutMask() {
        String cpfValido = "12345678909";
        boolean resultado = validator.isValid(cpfValido, Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertTrue(resultado);
    }

    @Test
    @DisplayName("Should return true for valid CPF with mask")
    void shouldReturnTrueForValidCpfWithMask() {
        String cpfValidoComMascara = "123.456.789-09";
        boolean resultado = validator.isValid(cpfValidoComMascara, Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertTrue(resultado);
    }

}
