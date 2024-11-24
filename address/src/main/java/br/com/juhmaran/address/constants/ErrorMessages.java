package br.com.juhmaran.address.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessages {

    INVALID_ZIP_CODE("CEP inválido: deve conter exatamente 8 dígitos numéricos."),
    INVALID_STATE_ABBREVIATION("O campo 'stateAbbreviation' deve conter exatamente 2 letras maiúsculas."),
    VALIDATION_ERROR("Erro de validação nos campos fornecidos.");

    private final String message;

}

