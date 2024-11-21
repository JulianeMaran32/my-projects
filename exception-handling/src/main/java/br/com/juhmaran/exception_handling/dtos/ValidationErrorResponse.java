package br.com.juhmaran.exception_handling.dtos;

import lombok.Getter;

import java.util.Map;

/**
 * DTO para representar uma resposta de erro de validação.
 *
 * @author Juliane Maran
 * @since 2024-11-20
 */
@Getter
public class ValidationErrorResponse extends ErrorResponse {

    private final Map<String, String> errors;

    public ValidationErrorResponse(int code, String status, String message, Map<String, String> errors) {
        super(code, status, message);
        this.errors = errors;
    }

}