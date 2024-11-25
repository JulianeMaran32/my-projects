package br.com.juhmaran.customer.api.domain.dtos;

import br.com.juhmaran.customer.core.util.CpfUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

    private Long id;
    private String name;
    private String email;
    private String cpf;

    public String getCpf() {
        return CpfUtil.removeMask(this.cpf);
    }

}
