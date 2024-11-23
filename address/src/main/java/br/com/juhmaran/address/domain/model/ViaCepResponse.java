package br.com.juhmaran.address.domain.model;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ViaCepResponse {

    @Pattern(regexp = "^\\d{8}$", message = "CEP inválido")
    private String cep;

    @Size(min = 3, message = "O campo 'logradouro' deve ter no mínimo {min} caracteres")
    private String logradouro;

    private String bairro;

    @Size(min = 3, message = "O campo 'localidade' deve ter no mínimo {min} caracteres")
    private String localidade;

    @Pattern(regexp = "^[A-Z]{2}$", message = "UF inválida")
    private String uf;

    private String estado;

}
