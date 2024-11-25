package br.com.juhmaran.customer.core.validation;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NotEmptyNotNullNotBlankValidatorTest {

    private final NotEmptyNotNullNotBlankValidator validator = new NotEmptyNotNullNotBlankValidator();

    @Test
    @DisplayName("Deve retornar falso para valor nulo")
    void deveRetornarFalsoParaValorNulo() {
        boolean resultado = validator.isValid(null, Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertFalse(resultado);
    }

    @Test
    @DisplayName("Deve retornar falso para valor em branco")
    void deveRetornarFalsoParaValorEmBranco() {
        boolean resultado = validator.isValid("   ", Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertFalse(resultado);
    }

    @Test
    @DisplayName("Deve retornar verdadeiro para valor válido")
    void deveRetornarVerdadeiroParaValorValido() {
        boolean resultado = validator.isValid("Texto válido", Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertTrue(resultado);
    }

}
