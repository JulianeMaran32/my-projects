package br.com.juhmaran.customer.core.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CpfUtilTest {

    @Test
    @DisplayName("Should remove mask from CPF")
    void shouldRemoveMaskFromCpf() {
        String cpfComMascara = "123.456.789-00";
        String cpfSemMascara = CpfUtil.removeMask(cpfComMascara);
        Assertions.assertEquals("12345678900", cpfSemMascara);
    }

    @Test
    @DisplayName("Should return null when CPF is null")
    void shouldReturnNullWhenCpfIsNull() {
        String resultado = CpfUtil.removeMask(null);
        Assertions.assertNull(resultado);
    }

    @Test
    @DisplayName("Should return empty string for empty CPF")
    void shouldReturnEmptyStringForEmptyCpf() {
        String cpfVazio = "";
        String resultado = CpfUtil.removeMask(cpfVazio);
        Assertions.assertEquals("", resultado);
    }
}
