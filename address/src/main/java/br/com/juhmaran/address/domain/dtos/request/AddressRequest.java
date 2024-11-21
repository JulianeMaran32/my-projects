package br.com.juhmaran.address.domain.dtos.request;

import br.com.juhmaran.address.validators.ValidCep;
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
public class AddressRequest {

    @ValidCep
    private String zipCode;

    @Size(max = 150, message = "O campo 'street' deve ter no máximo {max} caracteres, mas foi fornecido: {validatedValue}")
    private String street;

    @Size(max = 150, message = "O campo 'complement' deve ter no máximo {max} caracteres")
    private String complement;

    @Size(max = 50, message = "O campo 'unit' deve ter no máximo {max} caracteres")
    private String unit;

    @Size(max = 100, message = "O campo 'neighborhood' deve ter no máximo {max} caracteres")
    private String neighborhood;

    @Size(max = 100, message = "O campo 'city' deve ter no máximo {max} caracteres")
    private String city;

    @Pattern(regexp = "^[A-Z]{2}$", message = "A 'stateAbbreviation' deve conter exatamente 2 letras maiúsculas")
    private String stateAbbreviation;

    @Size(max = 100, message = "O campo 'state' deve ter no máximo {max} caracteres")
    private String state;

    @Size(max = 30, message = "O campo 'country' deve ter no máximo {max} caracteres")
    private String country;

}
