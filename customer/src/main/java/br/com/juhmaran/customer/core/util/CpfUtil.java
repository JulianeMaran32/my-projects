package br.com.juhmaran.customer.core.util;

public class CpfUtil {

    public static String removeMask(String cpf) {
        if (cpf == null) {
            return null;
        }
        return cpf.replaceAll("\\D", "");
    }

}
