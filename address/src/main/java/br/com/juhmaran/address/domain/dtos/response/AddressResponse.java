package br.com.juhmaran.address.domain.dtos.response;

import br.com.juhmaran.address.validators.ValidCep;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {

    private Long id;

    @ValidCep
    private String zipCode;
    private String street;
    private String complement;
    private String unit;
    private String neighborhood;
    private String city;
    private String stateAbbreviation;
    private String state;
}
