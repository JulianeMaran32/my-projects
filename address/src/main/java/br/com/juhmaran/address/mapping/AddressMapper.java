package br.com.juhmaran.address.mapping;

import br.com.juhmaran.address.domain.dtos.request.RegisterAddressRequest;
import br.com.juhmaran.address.domain.dtos.request.UpdateAddressRequest;
import br.com.juhmaran.address.domain.dtos.response.AddressResponse;
import br.com.juhmaran.address.domain.entities.AddressEntity;
import br.com.juhmaran.address.domain.model.ViaCepResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "zipCode", source = "zipCode")
    @Mapping(target = "street", ignore = true)
    @Mapping(target = "number", source = "number")
    @Mapping(target = "complement", source = "complement")
    @Mapping(target = "neighborhood", ignore = true)
    @Mapping(target = "city", ignore = true)
    @Mapping(target = "stateAbbreviation", ignore = true)
    @Mapping(target = "state", ignore = true)
    @Mapping(target = "country", source = "country", defaultValue = "Brasil")
    AddressEntity addressRequestToEntity(RegisterAddressRequest registerAddressRequest);

    AddressResponse addressEntityToResponse(AddressEntity addressEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "zipCode", source = "cep")
    @Mapping(target = "street", source = "logradouro")
    @Mapping(target = "number", ignore = true)
    @Mapping(target = "complement", ignore = true)
    @Mapping(target = "neighborhood", source = "bairro")
    @Mapping(target = "city", source = "localidade")
    @Mapping(target = "stateAbbreviation", source = "uf")
    @Mapping(target = "state", source = "estado")
    @Mapping(target = "country", ignore = true)
    AddressEntity viaCepResponseToEntity(ViaCepResponse viaCepResponse);

    @Mapping(target = "id", ignore = true)
    AddressEntity updateAddressRequestToEntity(UpdateAddressRequest updateAddressRequest);

    @Mapping(target = "id", ignore = true)
    void updateAddressEntity(@MappingTarget AddressEntity existingAddress, UpdateAddressRequest updateAddressRequest);

}
