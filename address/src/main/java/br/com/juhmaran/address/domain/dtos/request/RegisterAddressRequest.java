package br.com.juhmaran.address.domain.dtos.request;

import br.com.juhmaran.address.validators.annotations.ValidZipCode;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterAddressRequest {

    @ValidZipCode
    private String zipCode;

    private String number;

    private String complement;

    private String country;

    @NotNull(message = "O campo userId não pode ser nulo.")
    private Long userId;

}
