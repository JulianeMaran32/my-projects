package br.com.juhmaran.address.domain.dtos.request;

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
public class UpdateAddressRequest {

    @Pattern(regexp = "^\\d{8}$", message = "CEP inválido")
    private String zipCode;

    @Size(min = 3, message = "O campo 'street' deve ter no mínimo {min} caracteres")
    private String street;

    private String number;

    private String complement;

    private String neighborhood;

    @Size(min = 3, message = "O campo 'city' deve ter no mínimo {min} caracteres")
    private String city;

    @Pattern(regexp = "^[A-Z]{2}$", message = "A 'stateAbbreviation' deve conter exatamente 2 letras maiúsculas")
    private String stateAbbreviation;

    private String state;

    private String country;

}
