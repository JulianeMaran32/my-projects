package br.com.juhmaran.customer.api.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "CustomerResponse", description = "Objeto de resposta para clientes")
public class CustomerResponse {

    @Schema(name = "id", description = "Identificador do cliente", example = "1")
    private Long id;

    @Schema(name = "fullName", description = "Nome completo do cliente", example = "João da Silva")
    private String fullName;

    @Schema(name = "email", description = "E-mail do cliente", example = "joao.silva@email.com")
    private String email;

    @Schema(name = "documentNumber", description = "Número de documento do cliente (CPF)", example = "12345678909")
    private String documentNumber;

    @Schema(name = "phoneNumber", description = "Número de telefone do cliente", example = "11999999999")
    private String phoneNumber;

    @Schema(name = "active", description = "Indica se o cliente está ativo", example = "true")
    private Boolean active;

}
