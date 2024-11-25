package br.com.juhmaran.customer.core.validation;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ValidCpfValidatorTest {

    private final ValidCpfValidator validator = new ValidCpfValidator();

    @Test
    void deveRetornarFalsoParaCpfNulo() {
        boolean resultado = validator.isValid(null, Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertFalse(resultado);
    }

    @Test
    @DisplayName("Deve retornar falso para CPF vazio")
    void deveRetornarFalsoParaCpfInvalido() {
        String cpfInvalido = "12345678900"; // CPF inválido
        boolean resultado = validator.isValid(cpfInvalido, Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertFalse(resultado);
    }

    @Test
    @DisplayName("Deve retornar verdadeiro para CPF válido sem máscara")
    void deveRetornarVerdadeiroParaCpfValidoSemMascara() {
        String cpfValido = "12345678909"; // CPF válido
        boolean resultado = validator.isValid(cpfValido, Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve retornar verdadeiro para CPF válido com máscara")
    void deveRetornarVerdadeiroParaCpfValidoComMascara() {
        String cpfValidoComMascara = "123.456.789-09"; // CPF válido com máscara
        boolean resultado = validator.isValid(cpfValidoComMascara, Mockito.mock(ConstraintValidatorContext.class));
        Assertions.assertTrue(resultado);
    }

}
