package br.com.juhmaran.customer.core.utils;

public class CpfUtil {

    public static String removerMascara(String cpf) {
        if (cpf == null) {
            return null;
        }
        return cpf.replaceAll("\\D", ""); // Remove tudo que não é número
    }

}
