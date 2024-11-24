package br.com.juhmaran.address.exceptions.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.Map;

@Getter
@Schema(name = "ValidationErrorResponse", description = "Objeto de resposta para erros de validação")
public class ValidationErrorResponse extends ErrorResponse {

    @Schema(name = "errors", description = "Mapa de erros")
    private final Map<String, String> errors;

    public ValidationErrorResponse(int code, String status, String message, Map<String, String> errors) {
        super(code, status, message);
        this.errors = errors;
    }

}
