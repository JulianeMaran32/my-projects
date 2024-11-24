package br.com.juhmaran.address.domain.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "AddressResponse",
        description = "Classe que representa o objeto de resposta para endereço.")
public class AddressResponse {

    @Schema(description = "Identificador único do Endereço", example = "22")
    private Long id;

    @Schema(description = "CEP", example = "12345-678")
    private String zipCode;

    @Schema(description = "Logradouro (rua, avenida, alameda etc.)", example = "Rua das Flores")
    private String street;

    @Schema(description = "Número", example = "123")
    private String number;

    @Schema(description = "Complemento", example = "Casa")
    private String complement;

    @Schema(description = "Bairro", example = "Centro")
    private String neighborhood;

    @Schema(description = "Cidade", example = "São Paulo")
    private String city;

    @Schema(description = "UF", example = "SP")
    private String stateAbbreviation;

    @Schema(description = "Estado", example = "São Paulo")
    private String state;

    @Schema(description = "País", example = "Brasil")
    private String country;

    @Schema(description = "Identificador Único do Usuário", example = "12")
    private Long userId;

}
