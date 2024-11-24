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
    @Mapping(target = "number", source = "number")
    @Mapping(target = "complement", source = "complement")
    @Mapping(target = "street", ignore = true)
    @Mapping(target = "neighborhood", ignore = true)
    @Mapping(target = "city", ignore = true)
    @Mapping(target = "stateAbbreviation", ignore = true)
    @Mapping(target = "state", ignore = true)
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "country", source = "country", defaultValue = "Brasil")
    AddressEntity addressRequestToEntity(RegisterAddressRequest request);

    AddressResponse addressEntityToResponse(AddressEntity addressEntity);

    @Mapping(target = "street", source = "logradouro")
    @Mapping(target = "neighborhood", source = "bairro")
    @Mapping(target = "city", source = "localidade")
    @Mapping(target = "stateAbbreviation", source = "uf")
    @Mapping(target = "state", source = "estado")
    @Mapping(target = "country", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    default void updateAddressEntity(@MappingTarget AddressEntity entity, Object source) {
        if (source instanceof ViaCepResponse viaCepResponse) {
            entity.setStreet(viaCepResponse.getLogradouro());
            entity.setNeighborhood(viaCepResponse.getBairro());
            entity.setCity(viaCepResponse.getLocalidade());
            entity.setStateAbbreviation(viaCepResponse.getUf());
            entity.setState(viaCepResponse.getEstado());
        } else if (source instanceof UpdateAddressRequest updateRequest) {
            entity.setStreet(updateRequest.getStreet());
            entity.setNumber(updateRequest.getNumber());
            entity.setComplement(updateRequest.getComplement());
            entity.setNeighborhood(updateRequest.getNeighborhood());
            entity.setCity(updateRequest.getCity());
            entity.setStateAbbreviation(updateRequest.getStateAbbreviation());
            entity.setState(updateRequest.getState());
        }
    }
}
