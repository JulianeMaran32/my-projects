package br.com.juhmaran.address.domain.model;

import br.com.juhmaran.address.validators.annotations.ValidStateAbbreviation;
import br.com.juhmaran.address.validators.annotations.ValidZipCode;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "CEP", example = "12345-678", pattern = "^\\d{8}$")
    @ValidZipCode
    private String cep;

    @Schema(description = "Logradouro (rua, avenida, alameda etc.)", example = "Rua das Flores", minLength = 3)
    @Size(min = 3, message = "O campo 'logradouro' deve ter no mínimo {min} caracteres")
    private String logradouro;

    @Schema(description = "Bairro", example = "Centro")
    private String bairro;

    @Schema(description = "Localidade (Cidade)", example = "São Paulo", minLength = 3)
    @Size(min = 3, message = "O campo 'localidade' deve ter no mínimo {min} caracteres")
    private String localidade;

    @Schema(description = "UF", example = "SP", pattern = "^[A-Z]{2}$")
    @ValidStateAbbreviation
    private String uf;

    @Schema(description = "Estado", example = "São Paulo")
    private String estado;

}
