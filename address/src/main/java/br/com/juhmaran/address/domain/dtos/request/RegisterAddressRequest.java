package br.com.juhmaran.address.domain.dtos.request;

import br.com.juhmaran.address.validators.annotations.ValidZipCode;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "RegisterAddressRequest",
        description = "Classe que representa o objeto de requisição para registro de endereço.")
public class RegisterAddressRequest {

    @Schema(description = "CEP", example = "12345-678",
            pattern = "^\\d{8}$", requiredMode = Schema.RequiredMode.REQUIRED)
    @ValidZipCode
    private String zipCode;

    @Schema(description = "Número", example = "123",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String number;

    @Schema(description = "Complemento", example = "Casa",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String complement;

    @Schema(description = "País", example = "Brasil",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String country;

    @Schema(description = "Identificador único do Usuário", example = "12",
            requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "O campo userId não pode ser nulo.")
    private Long userId;

}
