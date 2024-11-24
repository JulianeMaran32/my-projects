package br.com.juhmaran.address.exceptions.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Schema(name = "ErrorResponse", description = "Objeto de resposta para erros")
public class ErrorResponse {

    @Schema(name = "code", description = "Código do erro")
    private int code;

    @Schema(name = "status", description = "Status do erro")
    private String status;

    @Schema(name = "message", description = "Mensagem de erro")
    private String message;

}
