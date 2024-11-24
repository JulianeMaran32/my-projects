package br.com.juhmaran.address.validators;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StateAbbreviationValidatorTest {

    private final StateAbbreviationValidator validator = new StateAbbreviationValidator();

    @Test
    @DisplayName("Testa se a sigla do estado é válida")
    public void testValidStateAbbreviation() {
        assertTrue(validator.isValid("SP", null));
    }

    @Test
    @DisplayName("Testa se a sigla do estado é inválida")
    public void testInvalidStateAbbreviation() {
        assertFalse(validator.isValid("São Paulo", null));
        assertFalse(validator.isValid("S", null));
        assertFalse(validator.isValid(null, null));
    }

}