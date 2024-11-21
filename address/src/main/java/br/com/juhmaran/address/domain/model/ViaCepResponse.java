package br.com.juhmaran.address.domain.model;

import br.com.juhmaran.address.validators.ValidCep;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ViaCepResponse {

    @ValidCep
    private String cep;

    private String logradouro;

    private String complemento;

    private String unidade;

    private String bairro;

    private String localidade;

    @Pattern(regexp = "^[A-Z]{2}$", message = "UF inválida")
    private String uf;

    private String estado;

}
