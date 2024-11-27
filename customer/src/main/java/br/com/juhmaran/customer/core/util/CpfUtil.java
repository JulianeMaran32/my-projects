package br.com.juhmaran.customer.core.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CpfUtil {

    public static String removeMask(String cpf) {
        log.debug("Starting to remove mask from CPF: {}", cpf);

        if (cpf == null) {
            log.warn("CPF is null");
            return null;
        }

        String cpfWithoutMask = cpf.replaceAll("\\D", "");
        log.debug("CPF without mask: {}", cpfWithoutMask);

        return cpfWithoutMask;
    }

}