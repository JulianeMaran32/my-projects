package br.com.juhmaran.address.mapping;

import br.com.juhmaran.address.domain.dtos.request.AddressRequest;
import br.com.juhmaran.address.domain.dtos.response.AddressResponse;
import br.com.juhmaran.address.domain.entities.AddressEntity;
import br.com.juhmaran.address.domain.model.ViaCepResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(target = "id", ignore = true)
    AddressEntity addressRequestToEntity(AddressRequest addressRequest);

    AddressResponse addressEntityToResponse(AddressEntity addressEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "country", ignore = true)
    @Mapping(target = "zipCode", source = "cep")
    @Mapping(target = "street", source = "logradouro")
    @Mapping(target = "complement", source = "complemento")
    @Mapping(target = "unit", source = "unidade")
    @Mapping(target = "neighborhood", source = "bairro")
    @Mapping(target = "city", source = "localidade")
    @Mapping(target = "stateAbbreviation", source = "uf")
    @Mapping(target = "state", source = "estado")
    AddressEntity viaCepResponseToEntity(ViaCepResponse viaCepResponse);

}
