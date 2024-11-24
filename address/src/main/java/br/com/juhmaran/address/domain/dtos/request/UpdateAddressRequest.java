package br.com.juhmaran.address.domain.dtos.request;

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
@Schema(name = "UpdateAddressRequest",
        description = "Classe que representa o objeto de requisição para atualização de endereço.")
public class UpdateAddressRequest {

    @Schema(description = "CEP", example = "12345-678",
            pattern = "^\\d{8}$", requiredMode = Schema.RequiredMode.REQUIRED)
    @ValidZipCode
    private String zipCode;

    @Schema(description = "Logradouro (rua, avenida, alameda etc.)", example = "Rua das Flores",
            minLength = 3, requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(min = 3, message = "O campo 'street' deve ter no mínimo {min} caracteres")
    private String street;

    @Schema(description = "Número", example = "123",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String number;

    @Schema(description = "Complemento", example = "Casa",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String complement;

    @Schema(description = "Bairro", example = "Centro",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String neighborhood;

    @Schema(description = "Localidade (Cidade)", example = "São Paulo",
            minLength = 3, requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @Size(min = 3, message = "O campo 'city' deve ter no mínimo {min} caracteres")
    private String city;

    @Schema(description = "UF", example = "SP",
            pattern = "^[A-Z]{2}$", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @ValidStateAbbreviation
    private String stateAbbreviation;

    @Schema(description = "Estado", example = "São Paulo",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String state;

    @Schema(description = "País", example = "Brasil",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String country;

}
