package br.com.juhmaran.address.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ZipCodeValidatorTest {

    private final ZipCodeValidator validator = new ZipCodeValidator();

    @Test
    @DisplayName("Testa se o CEP é válido")
    public void testValidZipCode() {
        Assertions.assertTrue(validator.isValid("12345678", null));
    }

    @Test
    @DisplayName("Testa se o CEP é inválido")
    public void testInvalidZipCode() {
        Assertions.assertFalse(validator.isValid("123", null));
        Assertions.assertFalse(validator.isValid("12345-678", null));
        Assertions.assertFalse(validator.isValid(null, null));
    }

}