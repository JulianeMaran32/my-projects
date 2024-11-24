package br.com.juhmaran.address.domain.dtos.request;

import br.com.juhmaran.address.validators.annotations.ValidStateAbbreviation;
import br.com.juhmaran.address.validators.annotations.ValidZipCode;
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

    @ValidZipCode
    private String zipCode;

    @Size(min = 3, message = "O campo 'street' deve ter no mínimo {min} caracteres")
    private String street;

    private String number;

    private String complement;

    private String neighborhood;

    @Size(min = 3, message = "O campo 'city' deve ter no mínimo {min} caracteres")
    private String city;

    @ValidStateAbbreviation
    private String stateAbbreviation;

    private String state;

    private String country;

}
