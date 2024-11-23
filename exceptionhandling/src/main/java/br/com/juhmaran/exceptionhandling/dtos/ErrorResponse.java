package br.com.juhmaran.exceptionhandling.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private int code;
    private String status;
    private String message;

}
