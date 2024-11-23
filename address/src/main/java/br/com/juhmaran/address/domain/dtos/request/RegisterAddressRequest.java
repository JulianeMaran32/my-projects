package br.com.juhmaran.address.domain.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterAddressRequest {

    @Pattern(regexp = "^\\d{8}$", message = "CEP inválido")
    @NotBlank(message = "O campo cep não pode estar em branco.")
    @NotNull(message = "O cep informando não pode ser nulo.")
    @NotEmpty(message = "O cep informado não pode estar vazio.")
    private String zipCode;

    private String number;

    private String complement;

    private String country;

}
