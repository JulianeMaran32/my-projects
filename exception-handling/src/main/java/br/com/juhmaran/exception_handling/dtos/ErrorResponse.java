package br.com.juhmaran.exception_handling.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * DTO para representar uma resposta de erro.
 *
 * @author Juliane Maran
 * @since 2024-11-20
 */
@Getter
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private int code;
    private String status;
    private String message;

}