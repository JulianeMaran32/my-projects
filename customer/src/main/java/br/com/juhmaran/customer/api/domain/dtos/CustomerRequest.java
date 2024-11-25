package br.com.juhmaran.customer.api.domain.dtos;

import br.com.juhmaran.customer.core.util.CpfUtil;
import br.com.juhmaran.customer.core.validation.annotations.NotEmptyNotNullNotBlank;
import br.com.juhmaran.customer.core.validation.annotations.ValidCpf;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
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

    @Size(min = 3, max = 150, message = "O campo nome deve ter entre {min} e {max} caracteres.")
    @NotEmptyNotNullNotBlank(message = "O campo nome não pode estar vazio, nulo ou em branco.")
    private String name;

    @Size(min = 3, max = 150, message = "O campo email deve ter entre {min} e {max} caracteres.")
    @NotEmptyNotNullNotBlank(message = "O campo email não pode estar vazio, nulo ou em branco.")
    @Email(message = "Informe um e-mail válido.")
    private String email;

    @ValidCpf(message = "CPF inválido. Informe um CPF válido com ou sem máscara.")
    @CPF(message = "Informe um número de CPF válido.")
    private String cpf;

    public String getCpf() {
        return CpfUtil.removeMask(this.cpf);
    }

}
