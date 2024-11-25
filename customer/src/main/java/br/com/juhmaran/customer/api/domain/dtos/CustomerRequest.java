package br.com.juhmaran.customer.domain.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    @NotBlank(message = "O campo nome não pode estar em branco")
    @NotNull(message = "O campo nome não pode ser nulo")
    @NotEmpty(message = "O campo nome não pode ser vazio")
    private String name;

    @NotBlank(message = "O campo email não pode estar em branco")
    @NotNull(message = "O campo email não pode ser nulo")
    @NotEmpty(message = "O campo email não pode ser vazio")
    @Email(message = "O campo email deve ser um email válido")
    private String email;

    @NotBlank(message = "O campo cpf não pode estar em branco")
    @NotNull(message = "O campo cpf não pode ser nulo")
    @NotEmpty(message = "O campo cpf não pode ser vazio")
    @CPF(message = "O campo cpf deve ser um número de CPF válido")
    private String cpf;

}
