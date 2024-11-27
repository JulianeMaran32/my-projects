package br.com.juhmaran.customer.api.mapping;

import br.com.juhmaran.customer.api.domain.dtos.CustomerRequest;
import br.com.juhmaran.customer.api.domain.dtos.CustomerResponse;
import br.com.juhmaran.customer.api.domain.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "id", ignore = true)
    Customer customerRequestToCustomer(CustomerRequest customerRequest);

    CustomerResponse customerToCustomerResponse(Customer customer);

}
