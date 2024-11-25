package br.com.juhmaran.customer.core.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CpfUtilTest {

    @Test
    @DisplayName("Deve adicionar máscara ao CPF")
    void deveRemoverMascaraDoCpf() {
        String cpfComMascara = "123.456.789-00";
        String cpfSemMascara = CpfUtil.removeMask(cpfComMascara);
        Assertions.assertEquals("12345678900", cpfSemMascara);
    }

    @Test
    @DisplayName("Deve retornar nulo quando CPF for nulo")
    void deveRetornarNuloQuandoCpfForNulo() {
        String cpfNulo = null;
        String resultado = CpfUtil.removeMask(cpfNulo);
        Assertions.assertNull(resultado);
    }

    @Test
    @DisplayName("Deve retornar string vazia para CPF vazio")
    void deveRetornarStringVaziaParaCpfVazio() {
        String cpfVazio = "";
        String resultado = CpfUtil.removeMask(cpfVazio);
        Assertions.assertEquals("", resultado);
    }
}
