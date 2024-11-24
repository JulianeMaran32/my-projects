package br.com.juhmaran.address.exceptions.dtos;

import lombok.Getter;

import java.util.Map;

@Getter
public class ValidationErrorResponse extends ErrorResponse {

    private final Map<String, String> errors;

    public ValidationErrorResponse(int code, String status, String message, Map<String, String> errors) {
        super(code, status, message);
        this.errors = errors;
    }

}
